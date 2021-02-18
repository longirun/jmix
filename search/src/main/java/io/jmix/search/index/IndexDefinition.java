/*
 * Copyright 2020 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.jmix.search.index;

import io.jmix.search.index.mapping.IndexMappingConfig;

import java.util.Set;

public class IndexDefinition {

    protected final String entityName;

    protected final Class<?> entityClass;

    protected final Set<Class<?>> affectedEntityClasses;

    protected final String indexName;

    protected final IndexMappingConfig mapping;

    //todo settings

    public IndexDefinition(String entityName, Class<?> entityClass, String indexName, IndexMappingConfig mapping, Set<Class<?>> affectedEntityClasses) {
        this.entityName = entityName;
        this.entityClass = entityClass;
        this.indexName = indexName;
        this.mapping = mapping;
        this.affectedEntityClasses = affectedEntityClasses;
    }

    public String getEntityName() {
        return entityName;
    }

    public Class<?> getEntityClass() {
        return entityClass;
    }

    public String getIndexName() {
        return indexName;
    }

    public IndexMappingConfig getMapping() {
        return mapping;
    }

    public Set<Class<?>> getAffectedEntityClasses() {
        return affectedEntityClasses;
    }
}
