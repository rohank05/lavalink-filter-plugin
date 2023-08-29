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
import me.rohank05.reverb.ReverberationPcmAudioFilter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ReverbFilter implements AudioFilterExtension {

    private static final Logger log = LoggerFactory.getLogger(ReverbFilter.class);

    public ReverbFilter() {
        log.info("Loading ReverbFilter...");
    }


    @Override
    public String getName() {
        return "reverb";
    }

    @Override
    public FloatPcmAudioFilter build(JSONObject data, AudioDataFormat format, FloatPcmAudioFilter output) {
        return new ReverberationPcmAudioFilter(output, format.channelCount, format.sampleRate).setDelays(getArray(data.getJSONArray("delays"))).setGains(getArray(data.getJSONArray("gains")));
    }

    @Override
    public boolean isEnabled(JSONObject data) {
        return getArray(data.getJSONArray("delays")).length > 0 || getArray(data.getJSONArray("gains")).length > 0;
    }

    private float[] getArray(JSONArray array){
        float[] floatArray = new float[array.length()];

        // Populate the float array with values from the JSON array
        for (int i = 0; i < array.length(); i++) {
            floatArray[i] = array.getFloat(i);
        }
        return floatArray;
    }
}
