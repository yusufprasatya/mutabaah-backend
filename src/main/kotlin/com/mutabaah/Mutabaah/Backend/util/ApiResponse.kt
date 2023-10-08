package com.mutabaah.Mutabaah.Backend.util

import com.mutabaah.Mutabaah.Backend.dto.ResponseDto
import org.springframework.http.HttpStatus

object DtoUtil {

    fun <T> responseDtoSuccess(data: T): ResponseDto<T> {
        return ResponseDto(
            true,
            HttpStatus.OK.toString(),
            "Data Found",
            data
        )
    }

    fun <T> responseDtoFailed(data: T): ResponseDto<T> {
        return ResponseDto(
            false,
            HttpStatus.OK.toString(),
            "Data Not Found",
            data
        )
    }

    fun <T> responseDtoFailed(data: T, errorMessage: String, httpStatus: HttpStatus): ResponseDto<T> {
        return ResponseDto(
            false,
            httpStatus.toString(),
            errorMessage,
            data
        )
    }
}
