package me.rohank05.plugin;

import com.sedmelluq.discord.lavaplayer.filter.FloatPcmAudioFilter;
import com.sedmelluq.discord.lavaplayer.format.AudioDataFormat;
import dev.arbjerg.lavalink.api.AudioFilterExtension;
import dev.arbjerg.lavalink.api.ISocketContext;
import dev.arbjerg.lavalink.api.PluginEventHandler;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EchoFilter implements AudioFilterExtension {

    private static final Logger log = LoggerFactory.getLogger(EchoFilter.class);

    public EchoFilter() {
        log.info("Hello, world!");
    }


    @Override
    public String getName() {
        return "echo";
    }

    @Override
    public FloatPcmAudioFilter build(JSONObject data, AudioDataFormat format, FloatPcmAudioFilter output) {
        return null;
    }

    @Override
    public boolean isEnabled(JSONObject data) {
        return false;
    }
}
