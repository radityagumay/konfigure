package nz.co.trademe.konfigure.firebase

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import nz.co.trademe.konfigure.api.ConfigSource

/**
 * A simple FirebaseRemoteConfig source, for integration with konfigure.
 *
 * @param remoteConfig The [FirebaseRemoteConfig] instance to use for retrieving values from
 */
class FirebaseRemoteConfigSource(
    private val remoteConfig: FirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
): ConfigSource {

    override val all: Map<String, String>
        get() = remoteConfig.all
            .mapValues { (_, value) -> value.asString() }

}