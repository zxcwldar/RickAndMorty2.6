package com.example.rickandmorty2.base

import com.example.rickandmorty2.common.resourse.Resource
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.lang.Exception

open class BaseRepository {
    protected fun <T> doRequest(
        request: suspend () -> T,
        writeDatabase: suspend (data: T) -> Unit
    ) = flow {
        emit(Resource.Loading())
        try {
            request().let {
                writeDatabase(it)
                emit(Resource.Success(data = it))
            }
        } catch (ioException: Exception) {
            emit(
                Resource.Error(
                    data = null, message = ioException.localizedMessage ?: "Error Occurred!"
                )
            )
        }
    }

    protected fun <T> doRequest(request: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data = request()))
        } catch (ioException: Exception) {
            emit(
                Resource.Error(
                    data = null, message = ioException.localizedMessage ?: "Error Occurred!"
                )
            )
        }
    }
}
