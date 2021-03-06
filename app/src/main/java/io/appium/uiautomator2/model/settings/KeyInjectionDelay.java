/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
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

package io.appium.uiautomator2.model.settings;

import android.support.test.uiautomator.Configurator;

public class KeyInjectionDelay extends AbstractSetting<Integer> {

    public static final String SETTING_NAME = Settings.keyInjectionDelay.toString();

    public KeyInjectionDelay() {
        super(Integer.class);
    }

    static public long getTime() {
        return Configurator.getInstance().getKeyInjectionDelay();
    }

    @Override
    public String getSettingName() {
        return SETTING_NAME;
    }

    @Override
    protected void apply(Integer timeout) {
        Configurator.getInstance().setKeyInjectionDelay(timeout);
    }
}
