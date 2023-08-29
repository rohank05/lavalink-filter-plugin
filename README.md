# lavalink-filter-plugin
[![](https://jitpack.io/v/me.rohank05/lavalink-filter-plugin.svg)](https://jitpack.io/#me.rohank05/lavalink-filter-plugin)


A [Lavalink](https://github.com/freyacodes/Lavalink) plugin to add extra audio filters.

`*Filter is added using lavadsp conveter`


## Installation

To install this plugin either download the latest release and place it into your `plugins` folder or add the following into your `application.yml`

```yaml
lavalink:
  plugins:
    - dependency: "me.rohank05:lavalink-filter-plugin:x.x.x" # replace x.x.x with the latest release tag!
      repository: "https://jitpack.io"
```

### Filters
```yaml
{
    "op": "filters",
    "guildId": "...",
    // Creates an Echo effect
    "echo": {
        "delay": 1.0, // in seconds
        "decay": 0.5 // 0 ≤ x ≤ 1
    },
    "reverb": {
        "delays": [0.037f, 0.042f, 0.048f, 0.053f],
        "gains": [0.84f, 0.83f, 0.82f, 0.81f]
    }
}
```