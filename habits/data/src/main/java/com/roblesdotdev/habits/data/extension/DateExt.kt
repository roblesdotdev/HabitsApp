package com.roblesdotdev.habits.data.extension

import java.time.Instant
import java.time.LocalDate
import java.time.LocalTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit

/**
 * Converts a ZonedDateTime to an epoch timestamp (in milliseconds)
 * truncated to the start of the day (00:00) in the same zone.
 */
fun ZonedDateTime.toStartOfDateTimestamp(): Long {
    return truncatedTo(ChronoUnit.DAYS).toEpochSecond() * 1000
}

/**
 * Converts an epoch timestamp (in milliseconds) to a ZonedDateTime
 * using the system default time zone.
 */
fun Long.toZonedDateTime(): ZonedDateTime {
    return ZonedDateTime.ofInstant(
        Instant.ofEpochMilli(this),
        ZoneId.systemDefault()
    )
}

/**
 * Converts a ZonedDateTime to an epoch timestamp (in milliseconds),
 * preserving the full date-time and time zone information.
 */
fun ZonedDateTime.toTimeStamp(): Long {
    return this.toInstant().toEpochMilli()
}

/**
 * Converts a LocalDate to a ZonedDateTime at the start of the day (00:00)
 * using the system default time zone.
 */
fun LocalDate.toZonedDateTime(): ZonedDateTime {
    return this.atStartOfDay(ZoneId.systemDefault())
}

/**
 * Converts a LocalTime to a ZonedDateTime using today's date
 * and the system default time zone.
 */
fun LocalTime.toZonedDateTime(): ZonedDateTime {
    return this.atDate(LocalDate.now()).atZone(ZoneId.systemDefault())
}
