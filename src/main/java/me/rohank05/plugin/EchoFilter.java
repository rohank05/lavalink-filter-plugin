/**
 * Copyright 2022 Rohan Kumar
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
package me.rohank05.plugin;

import com.sedmelluq.discord.lavaplayer.filter.FloatPcmAudioFilter;
import com.sedmelluq.discord.lavaplayer.format.AudioDataFormat;
import dev.arbjerg.lavalink.api.AudioFilterExtension;
import me.rohank05.echo.EchoPcmAudioFilter;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EchoFilter implements AudioFilterExtension {

    private static final Logger log = LoggerFactory.getLogger(EchoFilter.class);

    public EchoFilter() {
        log.info("Loading EchoFilter...");
    }


    @Override
    public String getName() {
        return "echo";
    }

    @Override
    public FloatPcmAudioFilter build(JSONObject data, AudioDataFormat format, FloatPcmAudioFilter output) {
        return new EchoPcmAudioFilter(output, format.channelCount, format.sampleRate)
                .setDecay(data.getFloat("decay")).setDelay(data.getDouble("delay"));
    }

    @Override
    public boolean isEnabled(JSONObject data) {
        return data.getFloat("decay")!= 1.0f || data.getDouble("delay") != 0;
    }
}
