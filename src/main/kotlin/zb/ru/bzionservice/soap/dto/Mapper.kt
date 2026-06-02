package zb.ru.bzionservice.soap.dto

interface Mapper<SRC, DST> {
    fun transform(source: SRC?): DST
}