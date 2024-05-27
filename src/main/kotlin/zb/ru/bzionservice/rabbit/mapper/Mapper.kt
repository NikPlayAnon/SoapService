package zb.ru.bzionservice.rabbit.mapper

interface Mapper<SRC, DST> {
    fun transform(source: SRC?): DST
}