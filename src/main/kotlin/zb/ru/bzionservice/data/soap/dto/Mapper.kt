package zb.ru.bzionservice.data.soap.dto

interface Mapper<SRC, DST> {
    fun transform(source: SRC?): DST
}