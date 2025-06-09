package com.roblesdotdev.core.presentation.ui

import com.roblesdotdev.core.domain.util.DataError

fun DataError.asUIText(): UIText {
    return when(this) {
        DataError.Local.DISK_FULL -> UIText.StringResource(
            R.string.error_disk_full
        )
        DataError.Local.UNKNOWN -> UIText.StringResource(
            R.string.error_unknown
        )
        DataError.Network.NO_INTERNET -> UIText.StringResource(
            R.string.error_no_internet
        )
        DataError.Network.REQUEST_TIMEOUT -> UIText.StringResource(
            R.string.error_request_timeout
        )
        DataError.Network.TOO_MANY_REQUESTS -> UIText.StringResource(
            R.string.error_rate_limit
        )
        DataError.Network.SERVER_ERROR -> UIText.StringResource(
            R.string.error_server_error
        )
        DataError.Network.SERIALIZATION -> UIText.StringResource(
            R.string.error_serialization
        )
        else -> UIText.StringResource(R.string.error_unknown)
    }
}