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

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import io.appium.uiautomator2.model.Session;

import static io.appium.uiautomator2.model.Session.CAP_ELEMENT_RESPONSE_ATTRIBUTES;

public class ElementResponseAttributesTest {

    private ElementResponseAttributes elementResponseAttributes;

    @Before
    public void setup() {
        elementResponseAttributes = new ElementResponseAttributes();
    }

    @Test
    public void shouldBeString() {
        Assert.assertEquals(String.class, elementResponseAttributes.getValueType());
    }

    @Test
    public void shouldReturnValidSettingName() {
        Assert.assertEquals("elementResponseAttributes", elementResponseAttributes.getSettingName());
    }

    @Test
    public void shouldBeAbleToDisableElementResponseAttributes() {
        Session.capabilities.remove(CAP_ELEMENT_RESPONSE_ATTRIBUTES);

        Assert.assertEquals(false, ElementResponseAttributes.isEnabled());
    }

    @Test
    public void shouldBeAbleToEnableElementResponseAttributes() {
        Session.capabilities.put(CAP_ELEMENT_RESPONSE_ATTRIBUTES, "a,b");

        Assert.assertEquals(true, ElementResponseAttributes.isEnabled());
    }
}
