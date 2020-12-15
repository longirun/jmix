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

package io.jmix.core.datastore;

import io.jmix.core.JmixOrder;
import org.springframework.core.Ordered;

public interface DataStoreInterceptor extends Ordered {
    default void beforeEntityLoad(BeforeEntityLoadEvent event) {
    }

    default void entityLoading(EntityLoadingEvent event) {
    }

    default void afterEntityLoad(AfterEntityLoadEvent event) {
    }

    default void beforeEntityCount(BeforeEntityCountEvent event) {
    }

    default void beforeEntitySave(BeforeEntitySaveEvent event) {
    }

    default void entitySaving(EntitySavingEvent event) {
    }

    default void entityDeleting(EntityDeletingEvent event) {
    }

    @Override
    default int getOrder() {
        return JmixOrder.LOWEST_PRECEDENCE;
    }
}