package com.nizzle94.data.cache

import com.nizzle94.data.reponse.GenreResponse
import io.reactivex.Single
import io.rx_cache2.DynamicKeyGroup
import io.rx_cache2.EvictDynamicKeyGroup
import io.rx_cache2.LifeCache
import java.util.concurrent.TimeUnit

/**
 * Created by Khajiev Nizomjon on 13/06/2018.
 */
interface CacheProvider {

    @LifeCache(duration = 1, timeUnit = TimeUnit.DAYS)
    fun getGenres(
        genreResponse: Single<GenreResponse>,
        query: DynamicKeyGroup,
        evictDynamicKeyGroup: EvictDynamicKeyGroup
    ): Single<GenreResponse>

}