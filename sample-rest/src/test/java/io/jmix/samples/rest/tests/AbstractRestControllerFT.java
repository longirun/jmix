/*
 * Copyright (c) 2008-2016 Haulmont. All rights reserved.
 * Use is subject to license terms, see http://www.cuba-platform.com/commercial-software-license for details.
 */

package io.jmix.samples.rest.tests;

import io.jmix.core.CoreConfiguration;
import io.jmix.core.DataManager;
import io.jmix.core.security.InMemoryUserRepository;
import io.jmix.data.DataConfiguration;
import io.jmix.rest.RestConfiguration;
import io.jmix.samples.rest.JmixRestTestConfiguration;
import io.jmix.samples.rest.SampleRestApplication;
import io.jmix.samples.rest.api.DataSet;
import io.jmix.samples.rest.security.FullAccessRole;
import io.jmix.security.SecurityConfiguration;
import io.jmix.security.role.RoleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;

import static io.jmix.samples.rest.tools.RestSpecsUtils.getAuthToken;
import static io.jmix.security.authentication.RoleGrantedAuthority.ofRole;

@ContextConfiguration(classes = {
        CoreConfiguration.class,
        DataConfiguration.class,
        SecurityConfiguration.class,
        RestConfiguration.class,
        JmixRestTestConfiguration.class})
@SpringBootTest(classes = SampleRestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractRestControllerFT {

    protected static final String DB_URL = "jdbc:hsqldb:mem:testdb";

    @LocalServerPort
    protected int port;

    @Autowired
    protected JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Autowired
    protected InMemoryUserRepository userRepository;

    @Autowired
    protected RoleRepository roleRepository;

    @Autowired
    protected DataManager dataManager;

    protected UserDetails admin;

    protected Connection conn;
    protected DataSet dirtyData = new DataSet();
    protected String oauthToken;
    protected String baseUrl;

    @BeforeEach
    public void setUp() throws Exception {
        admin = User.builder()
                .username("admin")
                .password("{noop}admin123")
                .authorities(ofRole(roleRepository.getRoleByCode(FullAccessRole.NAME)))
                .build();

        userRepository.addUser(admin);

        baseUrl = "http://localhost:" + port + "/rest";

        oauthToken = getAuthToken(baseUrl, "admin", "admin123");
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        conn = DriverManager.getConnection(DB_URL, "sa", "");
        prepareDb();
    }

    @AfterEach
    public void tearDown() throws Exception {
        dirtyData.cleanup(conn);
        if (conn != null) {
            conn.close();
        }
        userRepository.removeUser(admin);
    }

    public void prepareDb() throws Exception {
    }
}
