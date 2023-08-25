package com.mxpj.bookquiz.data

import com.mxpj.bookquiz.R
import com.mxpj.bookquiz.domain.Book
import com.mxpj.bookquiz.domain.BookRepository

class BookRepositoryImpl(
    private val bookDao: BookDao,
    private val bookMapper: BookMapper
    ): BookRepository {

    override suspend fun getBookList(): List<Book> {
        val list = bookDao.getBookList()
        if(list.isEmpty()){
            bookDao.addBooks(
                listOf(
                    BookDbModel(
                        "Бедная Лиза",
                        "Может быть, никто из живущих в Москве не знает так хорошо окрестностей города сего, как я",
                        R.drawable.bednaya_liza
                    ),
                    BookDbModel(
                        "Братья Карамазовы",
                        "Алексей Федорович Карамазов был третьим сыном помещика нашего уезда Федора Павловича Карамазова",
                        R.drawable.bratya_karamazovy
                    ),
                    BookDbModel(
                        "Дубровский",
                        "Несколько лет тому назад в одном из своих поместий жил старинный русский барин, Кирила Петрович Троекуров",
                        R.drawable.dubrovskiy
                    ),
                    BookDbModel(
                        "Герой нашего времени",
                        "Я ехал на перекладных из Тифлиса. Вся поклажа моей тележки состояла из одного небольшого чемодана",
                        R.drawable.geroy_nashego_vremeni
                    ),
                    BookDbModel(
                        "Идиот",
                        "В конце ноября, в оттепель, часов в девять утра, поезд Петербургско-Варшавской железной дороги на всех парах подходил к Петербургу",
                        R.drawable.idiot
                    ),
                    BookDbModel(
                        "Капитанская дочка",
                        "Отец мой Андрей Петрович Гринев в молодости своей служил при графе Минихе",
                        R.drawable.kapitanskaya_dochka
                    ),
                    BookDbModel(
                        "Казаки",
                        "Все затихло в Москве. Редко, редко где слышится визг колес по зимней улице",
                        R.drawable.kazaky
                    ),
                    BookDbModel(
                        "Мёртвые души",
                        "В ворота гостиницы губернского города NN въехала довольно красивая рессорная небольшая бричка",
                        R.drawable.mertvye_dushi
                    ),
                    BookDbModel(
                        "МуМу",
                        "В одной из отдаленных улиц Москвы, в сером доме с белыми колоннами, антресолью и покривившимся балконом, жила некогда барыня",
                        R.drawable.mumu
                    ),
                    BookDbModel(
                        "Нос",
                        "Марта 25 числа случилось в Петербурге необыкновенно странное происшествие",
                        R.drawable.nos
                    ),
                    BookDbModel(
                        "Преступление и наказание",
                        "В начале июля, в чрезвычайно жаркое время, под вечер, один молодой человек вышел из своей каморки",
                        R.drawable.prestuplenie_i_nakazanie
                    ),
                    BookDbModel(
                        "Старуха Изергиль",
                        "Я слышал эти рассказы под Аккерманом, в Бессарабии, на морском берегу.",
                        R.drawable.staruha_izergil
                    ),
                )
            )
        }
        return bookMapper.mapBookDbModelListToBookList(bookDao.getBookList())
    }
}