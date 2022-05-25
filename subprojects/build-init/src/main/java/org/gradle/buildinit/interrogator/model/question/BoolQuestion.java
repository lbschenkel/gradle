/*
 * Copyright 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.buildinit.interrogator.model.question;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.gradle.api.internal.tasks.userinput.UserInputHandler;

public class BoolQuestion extends Question {

    @JsonProperty("default")
    private Boolean defaultChoice;

    public Boolean getDefaultChoice() {
        return defaultChoice;
    }

    public void setDefaultChoice(Boolean defaultChoice) {
        this.defaultChoice = defaultChoice;
    }

    @Override
    public Boolean ask(UserInputHandler userInputHandler) {
        return userInputHandler.askYesNoQuestion(getQuestion(), getDefaultChoice());
    }

}
