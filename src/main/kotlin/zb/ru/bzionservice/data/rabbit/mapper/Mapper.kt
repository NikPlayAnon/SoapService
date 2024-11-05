package zb.ru.bzionservice.data.rabbit.mapper

interface Mapper<SRC, DST> {
    fun transform(source: SRC?): DST
}