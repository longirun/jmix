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

package com.haulmont.cuba.web.gui.components;

import com.haulmont.cuba.gui.components.PopupButton;
import io.jmix.ui.component.ComponentsHelper;
import io.jmix.ui.component.impl.PopupButtonImpl;

import java.util.function.Consumer;

@Deprecated
public class WebPopupButton extends PopupButtonImpl implements PopupButton {

    @Override
    public int getMenuWidthUnits() {
        return ComponentsHelper.convertFromSizeUnit(getMenuWidthSizeUnit());
    }

    @Override
    public void removePopupVisibilityListener(Consumer<PopupVisibilityEvent> listener) {
        internalRemovePopupVisibilityListener(listener);
    }
}
