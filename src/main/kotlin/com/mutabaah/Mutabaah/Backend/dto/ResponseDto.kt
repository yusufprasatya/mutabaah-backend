package com.mutabaah.Mutabaah.Backend.dto

data class ResponseDto<T>(
    var success: Boolean? = null,
    var status: String? = null,
    var message: String? = null,
    var data: T? = null
)
