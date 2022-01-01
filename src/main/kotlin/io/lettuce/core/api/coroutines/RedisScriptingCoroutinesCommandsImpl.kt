/*
 * Copyright 2020-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.lettuce.core.api.coroutines

import io.lettuce.core.ExperimentalLettuceCoroutinesApi
import io.lettuce.core.FlushMode
import io.lettuce.core.ScriptOutputType
import io.lettuce.core.api.reactive.RedisScriptingReactiveCommands
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirstOrNull


/**
 * Coroutine executed commands (based on reactive commands) for Scripting. [Lua scripts][java.lang.String] are encoded by using the configured
 * [charset][io.lettuce.core.ClientOptions#getScriptCharset()].
 *
 * @param <K> Key type.
 * @param <V> Value type.
 * @author Mikhael Sokolov
 * @since 6.0
 *
 * @generated by io.lettuce.apigenerator.CreateKotlinCoroutinesReactiveImplementation
 */
@ExperimentalLettuceCoroutinesApi
internal class RedisScriptingCoroutinesCommandsImpl<K : Any, V : Any>(internal val ops: RedisScriptingReactiveCommands<K, V>) : RedisScriptingCoroutinesCommands<K, V> {

    override suspend fun <T> eval(script: String, type: ScriptOutputType, vararg keys: K): T? = ops.eval<T>(script, type, *keys).awaitFirstOrNull()

    override suspend fun <T> eval(script: ByteArray, type: ScriptOutputType, vararg keys: K): T? = ops.eval<T>(script, type, *keys).awaitFirstOrNull()

    override suspend fun <T> eval(script: String, type: ScriptOutputType, keys: Array<K>, vararg values: V): T? = ops.eval<T>(script, type, keys, *values).awaitFirstOrNull()

    override suspend fun <T> eval(script: ByteArray, type: ScriptOutputType, keys: Array<K>, vararg values: V): T? = ops.eval<T>(script, type, keys, *values).awaitFirstOrNull()

    override suspend fun <T> evalsha(digest: String, type: ScriptOutputType, vararg keys: K): T? = ops.evalsha<T>(digest, type, *keys).awaitFirstOrNull()

    override suspend fun <T> evalsha(digest: String, type: ScriptOutputType, keys: Array<K>, vararg values: V): T? = ops.evalsha<T>(digest, type, keys, *values).awaitFirstOrNull()

    override suspend fun scriptExists(vararg digests: String): List<Boolean> = ops.scriptExists(*digests).asFlow().toList()

    override suspend fun scriptFlush(): String? = ops.scriptFlush().awaitFirstOrNull()

    override suspend fun scriptFlush(flushMode: FlushMode): String? = ops.scriptFlush(flushMode).awaitFirstOrNull()

    override suspend fun scriptKill(): String? = ops.scriptKill().awaitFirstOrNull()

    override suspend fun scriptLoad(script: String): String? = ops.scriptLoad(script).awaitFirstOrNull()

    override suspend fun scriptLoad(script: ByteArray): String? = ops.scriptLoad(script).awaitFirstOrNull()

    override suspend fun digest(script: String): String = ops.digest(script)

    override suspend fun digest(script: ByteArray): String = ops.digest(script)

}

