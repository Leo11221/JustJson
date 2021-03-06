/*
 * Copyright (C) 2014 Kalin Maldzhanski
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

package io.apptik.json.generator.generators.formats;

import io.apptik.json.JsonElement;
import io.apptik.json.JsonString;
import io.apptik.json.generator.JsonGeneratorConfig;
import io.apptik.json.generator.JsonGenerator;
import io.apptik.json.schema.Schema;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeGenerator extends JsonGenerator {

    public TimeGenerator(Schema schema, JsonGeneratorConfig configuration) {
        super(schema, configuration);
    }

    public TimeGenerator(Schema schema, JsonGeneratorConfig configuration, String propertyName) {
        super(schema, configuration, propertyName);
    }

    @Override
    public JsonElement generate() {
        Date dateTime = new Date(System.currentTimeMillis() - Math.abs(rnd.nextInt(3600000) * rnd.nextInt(24)));
        DateFormat df = new SimpleDateFormat("HH:mm:ssZ");
        return new JsonString(df.format(dateTime));
    }
}
