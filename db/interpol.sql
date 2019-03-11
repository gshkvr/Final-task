DROP DATABASE IF EXISTS interpol;
CREATE DATABASE IF NOT EXISTS interpol;
USE interpol;

CREATE TABLE `news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `ru_title` varchar(2000),
  `ru_text` text,
  `en_title` varchar(2000),
  `en_text` text,
  `default_title` varchar(2000),
  `default_text` text,
  PRIMARY KEY (`id`)
);

INSERT INTO news(date, ru_title, ru_text, en_title, en_text, default_title, default_text)
VALUES("2019-02-22",
"В Россию из Германии экстрадирован обвиняемый в хищении 60 миллионов рублей дольщиков",
"«Сегодня сотрудниками российского Бюро Интерпола и ФСИН России экстрадирован в Москву Валерий Марковкин, обвиняемый в мошенничестве», - сообщила официальный представитель МВД России Ирина Волк.\r\n
«По версии следствия, генеральный директор компании присвоил более 60 миллионов рублей, которые должны были пойти на строительство многоквартирного дома в Великом Новгороде.\r\n
Уголовное дело возбуждено по признакам преступления, предусмотренного частью 4 статьи 159 УК РФ. Скрывшийся от правоохранительных органов фигурант на основании запроса УМВД России по Новгородской области был объявлен в международный розыск в июне 2018 года и спустя месяц задержан в германском городе Зефтенберг», - рассказала Ирина Волк.\r\n
Удовлетворив ходатайство Генеральной прокуратуры Российской Федерации о выдаче, компетентные органы Германии передали фигуранта сотрудникам НЦБ Интерпола МВД России и ФСИН России. Экстрадиция состоялась.",
"Man accused of misappropriating investors' 60 million rubles was extradited from Germany to Russia",
"“Today, officers of the Russian Bureau of Interpol and the Federal Penitentiary Service of Russia extradited Valery Markovkin accused of a fraud to Moscow,” said Russian MIA official representative Irina Volk.\r\n
“According to the investigators, the director general of an entity had misappropriated over 60 million rubles that should have been used for erecting an apartment building in Veliky Novgorod.\r\n
The authorities initiated a criminal case based on essential elements of a crime stipulated by part 4 of Article 159 of the Criminal Code of the Russian Federation. The defendant escaped from the law enforcement bodies, due to which in June 2018 he was put on the international wanted list as requested by the Russian MIA Administration for the Novgorod Region. A month later, he was apprehended in Senftenberg, Germany,” added Irina Volk.\r\n
The German competent bodies satisfied the application from the Prosecutor General's Office of the Russian Federation for the extradition and delivered the defendant to officers of the National Central Bureau of Interpol of the Russian MIA and the Federal Penitentiary Service of the Russian Federation. The extradition was completed.",
"Man accused of misappropriating investors' 60 million rubles was extradited from Germany to Russia",
"“Today, officers of the Russian Bureau of Interpol and the Federal Penitentiary Service of Russia extradited Valery Markovkin accused of a fraud to Moscow,” said Russian MIA official representative Irina Volk.\r\n
“According to the investigators, the director general of an entity had misappropriated over 60 million rubles that should have been used for erecting an apartment building in Veliky Novgorod.\r\n
The authorities initiated a criminal case based on essential elements of a crime stipulated by part 4 of Article 159 of the Criminal Code of the Russian Federation. The defendant escaped from the law enforcement bodies, due to which in June 2018 he was put on the international wanted list as requested by the Russian MIA Administration for the Novgorod Region. A month later, he was apprehended in Senftenberg, Germany,” added Irina Volk.\r\n
The German competent bodies satisfied the application from the Prosecutor General's Office of the Russian Federation for the extradition and delivered the defendant to officers of the National Central Bureau of Interpol of the Russian MIA and the Federal Penitentiary Service of the Russian Federation. The extradition was completed.");
INSERT INTO news(date, ru_title, ru_text, en_title, en_text, default_title, default_text)
VALUES("2019-02-15", 
"Обвиняемого в хищении сельскохозяйственной техники экстрадировали из Сербии", 
"«В международном аэропорту г. Белграда состоялась передача Шмидта Александра, 1967 г.р., разыскиваемого по обвинению в совершении преступления, предусмотренного ч. 4 ст. 159 УК РФ», - сообщила официальный представитель МВД России Ирина Волк.\r\n
По версии следствия фигурант, являясь руководителем одного из агропромышленных комплексов Ставропольского края, совершил хищение сельскохозяйственной техники – 13 комбайнов, числящихся на балансе возглавляемого предприятия.\r\n
Так как Шмидт после совершения противоправного деяния покинул пределы Российской Федерации, он был объявлен в международный розыск в ноябре 2018 г. на основании запроса ГУ МВД России по Ставропольскому краю. В результате розыскных мероприятий в декабре 2018 г. его задержали на территории Сербии.\r\n
Сегодня в сопровождении сотрудников российского Интерпола и ФСИН России мужчина был доставлен в Москву.", 
"Man suspected of misappropriation of agricultural machinery was extradited from Serbia", 
"“Alexandr Schmidt born in 1967 was extradited at the international airport of Belgrade. The man had been wanted on a charge of a crime stipulated by part 4 of Article 159 of the Criminal Code of the Russian Federation,” said Russian MIA official representative Irina Volk.\r\n
According to the investigation bodies, the defendant being the head of an agroindustrial complex in the Stavropol Territory had misappropriated agricultural machinery, namely 13 combines recorded on the balance sheet of the enterprise under his management.\r\n
Having committed the offense, Schmidt escaped from the Russian Federation. Due to that, in November 2018 he was put on the international wanted list based on the request from the Russian MIA General Administration for the Stavropol Territory. As a result of the search operations, in December 2018 he was apprehended in Serbia.\r\n
Today, the man was convoyed to Moscow by officers of the Russian Bureau of Interpol and the Federal Penitentiary Service of Russia.", 
"Man suspected of misappropriation of agricultural machinery was extradited from Serbia", 
"“Alexandr Schmidt born in 1967 was extradited at the international airport of Belgrade. The man had been wanted on a charge of a crime stipulated by part 4 of Article 159 of the Criminal Code of the Russian Federation,” said Russian MIA official representative Irina Volk.\r\n
According to the investigation bodies, the defendant being the head of an agroindustrial complex in the Stavropol Territory had misappropriated agricultural machinery, namely 13 combines recorded on the balance sheet of the enterprise under his management.\r\n
Having committed the offense, Schmidt escaped from the Russian Federation. Due to that, in November 2018 he was put on the international wanted list based on the request from the Russian MIA General Administration for the Stavropol Territory. As a result of the search operations, in December 2018 he was apprehended in Serbia.\r\n
Today, the man was convoyed to Moscow by officers of the Russian Bureau of Interpol and the Federal Penitentiary Service of Russia.");
INSERT INTO news(date, ru_title, ru_text, en_title, en_text, default_title, default_text)
VALUES("2019-02-15", 
"Из Милана в Москву доставили гражданина России, разыскиваемого за убийство", 
"«В сопровождении сотрудников российского Бюро Интерпола и ФСИН России в г. Москву доставлен Исаков Мурад, 1979 г.р., обвиняемый в совершении преступлений, предусмотренных ч. 2 ст. 105 и ч. 1 ст. 222 УК РФ», - сообщила официальный представитель МВД России Ирина Волк.\r\n
Установлено, что в сентябре 2012 г. на ул. Ленина г. Избербаш мужчина совершил убийство своего знакомого по личным мотивам, после чего скрылся.\r\n
На основании запроса МВД по Республике Дагестан Исаков был объявлен в международный розыск и в результате оперативных мероприятий задержан на территории Италии в декабре 2018 года.", 
"Murder suspect was extradited from Milan to Moscow", 
"“Murad Isakov born in 1979 who is accused of crimes stipulated by part 2 of Article 105 and part 1 of Article 222 of the Criminal Code of the Russian Federation was extradited to Moscow convoyed by officers of the Russian Bureau of Interpol and the Federal Penitentiary Service of Russia,” said Russian MIA official representative Irina Volk.\r\n
According to the investigators, the man is suspected of the murder perpetrated in September 2012 on Lenina Street in Izberbash.\r\n
Based on the request from the MIA for the Republic of Dagestan, Isakov was put on the international wanted list and was detained in Italy in December 2018 as a result of the investigation operations.", 
"Murder suspect was extradited from Milan to Moscow", 
"“Murad Isakov born in 1979 who is accused of crimes stipulated by part 2 of Article 105 and part 1 of Article 222 of the Criminal Code of the Russian Federation was extradited to Moscow convoyed by officers of the Russian Bureau of Interpol and the Federal Penitentiary Service of Russia,” said Russian MIA official representative Irina Volk.\r\n
According to the investigators, the man is suspected of the murder perpetrated in September 2012 on Lenina Street in Izberbash.\r\n
Based on the request from the MIA for the Republic of Dagestan, Isakov was put on the international wanted list and was detained in Italy in December 2018 as a result of the investigation operations.");
INSERT INTO news(date, ru_title, ru_text, en_title, en_text, default_title, default_text)
VALUES("2019-02-14", 
"Из России в Чехию экстрадировали подозреваемого в убийстве", 
"«В международном аэропорту «Шереметьево» состоялась передача Краивского Юрия, 1976 г.р., правоохранительным органам Чехии.\r\n
Фигурант был объявлен в международный розыск в 2017 году по запросу Чешской Республики за совершение преступления, предусмотренного ст. 219 Уголовного кодекса этой страны (убийство). В 2018 году он был задержан на территории Ханты-Мансийского автономного округа», - сообщила официальный представитель МВД России Ирина Волк.", 
"Murder suspect was extradited from Russia to Czech Republic", 
"“Yury Kraivsky born in 1976 was extradited to the law enforcement bodies of the Czech Republic in the Sheremetyevo Airport.\r\n
The defendant had been put on the international wanted list in 2017 based on the request from Czechia for having committed a crime stipulated by Article 219 of the Criminal Code of the Czech Republic (murder). In 2018, he was apprehended in the Khanty-Mansi Autonomous Area,” said Russian MIA official representative Irina Volk.", 
"Murder suspect was extradited from Russia to Czech Republic", 
"“Yury Kraivsky born in 1976 was extradited to the law enforcement bodies of the Czech Republic in the Sheremetyevo Airport.\r\n
The defendant had been put on the international wanted list in 2017 based on the request from Czechia for having committed a crime stipulated by Article 219 of the Criminal Code of the Czech Republic (murder). In 2018, he was apprehended in the Khanty-Mansi Autonomous Area,” said Russian MIA official representative Irina Volk.");
INSERT INTO news(date, ru_title, ru_text, en_title, en_text, default_title, default_text)
VALUES("2019-02-01", 
"Обвиняемого в изготовлении поддельных банковских карт экстрадировали в Россию", 
"«В сопровождении сотрудников российского Бюро Интерпола и ФСИН России из Литвы доставлен Антонов Артем Викторович, 1986 г.р., обвиняемый в совершении преступления, предусмотренного ч. 2 ст. 187 УК РФ», - сообщила официальный представитель МВД России Ирина Волк.\r\n
Фигурант обвиняется в причастности к незаконному изготовлению и продаже платежных банковских карт. Незаконное производство было организовано в его квартире в Воронежской области. После изготовления, карты небольшими партиями отправлялись покупателям в другие города России.\r\n
«Выйти на подпольное производство удалось после того, как ряд карт был заблокирован банкоматами и передан представителями банков в правоохранительные органы. В результате оперативных мероприятий удалось ликвидировать подпольное предприятие. Антонов, ставший обвиняемый по уголовному делу об изготовлении подделок был объявлен в международный розыск на основании запроса ГУ МВД России по Воронежской области», - рассказала Ирина Волк.\r\n
Сегодня, удовлетворив ходатайство Генеральной прокуратуры Российской Федерации о выдаче, литовскиекомпетентные органы передали фигуранта сотрудникам НЦБ Интерпола МВД России и ФСИН России дляего доставки в г. Москву.", 
"Man accused of making fake bank cards was extradited to Russia", 
"“Accompanied by officers of the Russian Bureau of Interpol and the Federal Penitentiary Service of Russia, Artem Viktorovich Antonov, born in 1986 and accused of committing a crime under part 2 of Article 187 of the RF Criminal Code, was delivered from Lithuania,” said the official representative of the Russian MIA Irina Volk.\r\n
The suspect is accused of involvement in the illegal manufacture and sale of payment bank cards. The illegal production was organized in his apartment in the Voronezh Region. The manufactured cards were sent in small batches to customers in other cities of Russia.\r\n
“It became possible to track the clandestine production after a number of cards were blocked by ATMs and transferred by representatives of banks to law enforcement bodies. As a result of operational activities, the underground enterprise was liquidated. Antonov, who had become a defendant in a criminal case on the manufacture of fakes, was put on the international wanted list on the basis of a request from the MIA of Russia GA for the Voronezh Region,” Irina Volk said.\r\n
Today the Lithuanian competent authorities satisfied the request of the Prosecutor General of the Russian Federation on the extradition of the defendant and passed him over to officers of the MIA NCB of Interpol and of the Russian Federal Penitentiary Service for his delivery to Moscow.", 
"Man accused of making fake bank cards was extradited to Russia", 
"“Accompanied by officers of the Russian Bureau of Interpol and the Federal Penitentiary Service of Russia, Artem Viktorovich Antonov, born in 1986 and accused of committing a crime under part 2 of Article 187 of the RF Criminal Code, was delivered from Lithuania,” said the official representative of the Russian MIA Irina Volk.r\n
The suspect is accused of involvement in the illegal manufacture and sale of payment bank cards. The illegal production was organized in his apartment in the Voronezh Region. The manufactured cards were sent in small batches to customers in other cities of Russia.\r\n
“It became possible to track the clandestine production after a number of cards were blocked by ATMs and transferred by representatives of banks to law enforcement bodies. As a result of operational activities, the underground enterprise was liquidated. Antonov, who had become a defendant in a criminal case on the manufacture of fakes, was put on the international wanted list on the basis of a request from the MIA of Russia GA for the Voronezh Region,” Irina Volk said.\r\n
Today the Lithuanian competent authorities satisfied the request of the Prosecutor General of the Russian Federation on the extradition of the defendant and passed him over to officers of the MIA NCB of Interpol and of the Russian Federal Penitentiary Service for his delivery to Moscow.");
INSERT INTO news(date, ru_title, ru_text, en_title, en_text, default_title, default_text)
VALUES("2019-01-30", 
"Сотрудниками МВД России задержан подозреваемый, находившийся в международном розыске за совершение мошенничества", 
"Сотрудниками Главного управления уголовного розыска МВД России совместно с коллегами из НЦБ Интерпола МВД России задержан ранее судимый гражданин одной из стран СНГ, разыскиваемый за совершение мошенничества в Республике Беларусь.\r\n
Установлено, что в период с 2013 по 2016 годы, задержанный совершил ряд мошеннических действий, в результате которых завладел денежными средствами потерпевших в крупном размере.С июля 2017 года он находился в международном розыске.\r\n
В результате проведения оперативно-розыскных мероприятий установлено, что разыскиваемый работает в городской поликлинике № 1 г. Подольска Московской области, где он и был задержан сотрудниками полиции.", 
"MIA of Russia officers detained a suspect who was on the international wanted list for fraud", 
"Officers of the MIA of Russia GA for Criminal Investigation, together with colleagues from the National Central Bureau of Interpol of the MIA of Russia, detained a previously convicted citizen of one of the CIS countries who was on the wanted list for fraud in the Republic of Belarus.\r\n
It was established that in the period from 2013 to 2016, the detainee committed a series of fraudulent acts, as a result of which he appropriated the funds of the victims on a large scale. Since July 2017, he has been on the international wanted list.\r\n
As a result of the operational search activities, it was established that the wanted person worked in the city polyclinic No. 1 of the city of Podolsk, Moscow Region, where he was detained by the police.", 
"MIA of Russia officers detained a suspect who was on the international wanted list for fraud", 
"Officers of the MIA of Russia GA for Criminal Investigation, together with colleagues from the National Central Bureau of Interpol of the MIA of Russia, detained a previously convicted citizen of one of the CIS countries who was on the wanted list for fraud in the Republic of Belarus.\r\n
It was established that in the period from 2013 to 2016, the detainee committed a series of fraudulent acts, as a result of which he appropriated the funds of the victims on a large scale. Since July 2017, he has been on the international wanted list.\r\n
As a result of the operational search activities, it was established that the wanted person worked in the city polyclinic No. 1 of the city of Podolsk, Moscow Region, where he was detained by the police.");
INSERT INTO news(date, ru_title, ru_text, en_title, en_text, default_title, default_text)
VALUES("2018-12-14", 
"Один из основателей финансовой группы экстрадирован в Россию", 
"«Сегодня в сопровождении сотрудников НЦБ Интерпола МВД России и ФСИН России в Москву экстрадирован обвиняемый в мошенничестве», - сообщила официальный представитель МВД России Ирина Волк.\r\n
В период с 2013 по 2015 годы фигурант являлся одним из руководителей фирмы, которая привлекала денежные средства физических лиц под предлогом их вложения в высокодоходные инвестиционные проекты. Компания проводила агрессивную информационную политику в средствах массовой информации, распространяя ложные сведения о своей финансовой деятельности. Для привлечения большего числа вкладчиков производились частичные выплаты процентов по ранее заключенным договорам.\r\n
Летом 2015 года организация, которая имела представительства в 22 субъектах Российской Федерации, прекратила все выплаты и приём новых средств, оставив неисполненными более 10 тысяч договоров. Уголовное дело возбуждено по статье 159 УК РФ.\r\n
Скрывшегося от правоохранительных органов фигуранта объявили в международный розыск и впоследствии задержали в Чехии. Экстрадиция состоялась.", 
"A founder of a financial group was extradited to Russia", 
"“Today, accompanied by staff of the MIA of Russia National Central Bureau of Interpol and the Federal Penitentiary Service of Russia, a suspect of fraud was extradited to Moscow” said the official representative of the Russian MIA Irina Volk.\r\n
In the period from 2013 to 2015, the defendant was one of the top managers of the company, which attracted individuals' funds under the pretext of investing them in high-yield investment projects. The company pursued an aggressive information policy in the media, spreading false information about its financial activities. To attract a larger number of depositors, partial payments of interest on previously concluded contracts were made.\r\n
In the summer of 2015, the organization that had offices in 22 constituent entities of the Russian Federation stopped all payments and accepting of new funds, leaving more than 10,000 contracts unfulfilled. The criminal case was initiated under Article 159 of the Criminal Code of the Russian Federation.\r\n
The defendant hiding from law enforcement bodies was put on the international wanted list and subsequently detained in the Czech Republic. His extradition took place.", 
"A founder of a financial group was extradited to Russia", 
"“Today, accompanied by staff of the MIA of Russia National Central Bureau of Interpol and the Federal Penitentiary Service of Russia, a suspect of fraud was extradited to Moscow” said the official representative of the Russian MIA Irina Volk.\r\n
In the period from 2013 to 2015, the defendant was one of the top managers of the company, which attracted individuals' funds under the pretext of investing them in high-yield investment projects. The company pursued an aggressive information policy in the media, spreading false information about its financial activities. To attract a larger number of depositors, partial payments of interest on previously concluded contracts were made.\r\n
In the summer of 2015, the organization that had offices in 22 constituent entities of the Russian Federation stopped all payments and accepting of new funds, leaving more than 10,000 contracts unfulfilled. The criminal case was initiated under Article 159 of the Criminal Code of the Russian Federation.\r\n
The defendant hiding from law enforcement bodies was put on the international wanted list and subsequently detained in the Czech Republic. His extradition took place.");
INSERT INTO news(date, ru_title, ru_text, en_title, en_text, default_title, default_text)
VALUES("2018-12-13", 
"Из Индонезии в Россию доставлена обвиняемая в мошенничестве", 
"«Сегодня из Индонезии в Россию в сопровождении сотрудников НЦБ Интерпола МВД России доставлена 30-летняя руководитель туристической компании, обвиняемая в мошенничестве. Более 50 потерпевшим причинен ущерб, общая сумма которого превышает 4 миллиона рублей», - сообщила официальный представитель МВД России Ирина Волк.\r\n
Ранее сотрудники отдела экономической безопасности и противодействия коррупции МУ МВД России «Красноярское» установили, что директор турфирмы получила от клиентов деньги в качестве оплаты за заграничные поездки, но на счета туроператоров данные средства не поступили.\r\n
Возбуждены и расследуются уголовные дела по признакам преступлений, предусмотренных статьей 159 Уголовного кодекса Российской Федерации.\r\n
Подозреваемая скрылась от правоохранительных органов, в отношении нее заочно избрана мера пресечения в виде заключения под стражу, а затем она объявлена в международный розыск.\r\n
В результате международного сотрудничества компетентных органов разыскиваемая задержана в Индонезии.", 
"Suspect of fraud was brought from Indonesia to Russia", 
"“Today, a 30-year-old head of a travel company, accused of fraud, was brought from Indonesia to Russia accompanied by officers of the National Central Bureau of Interpol of the Russian MIA. More than 50 victims suffered a damage, the total amount of which exceeded 4 million rubles,” said the official representative of the MIA of Russia Irina Volk.\r\n
Earlier, officers of the Division for Economic Security and Combating the Corruption of the MIA of Russia Inter-District Administration “Krasnoyarskoye” found that the director of a travel agency had received money from clients as payment for foreign travel, but those funds were not transferred into the accounts of tour-operators.\r\n
Criminal cases on the grounds of crimes provided for by Article 159 of the Criminal Code of the Russian Federation were initiated and were being investigated.\r\n
The suspect escaped from law enforcement bodies, a preventive measure in the form of remand in custody was chosen for her in absentia, and then she was put on the international wanted list.\r\n
As a result of international cooperation of competent authorities, the wanted person was detained in Indonesia.", 
"Suspect of fraud was brought from Indonesia to Russia", 
"“Today, a 30-year-old head of a travel company, accused of fraud, was brought from Indonesia to Russia accompanied by officers of the National Central Bureau of Interpol of the Russian MIA. More than 50 victims suffered a damage, the total amount of which exceeded 4 million rubles,” said the official representative of the MIA of Russia Irina Volk.\r\n
Earlier, officers of the Division for Economic Security and Combating the Corruption of the MIA of Russia Inter-District Administration “Krasnoyarskoye” found that the director of a travel agency had received money from clients as payment for foreign travel, but those funds were not transferred into the accounts of tour-operators.\r\n
Criminal cases on the grounds of crimes provided for by Article 159 of the Criminal Code of the Russian Federation were initiated and were being investigated.\r\n
The suspect escaped from law enforcement bodies, a preventive measure in the form of remand in custody was chosen for her in absentia, and then she was put on the international wanted list.\r\n
As a result of international cooperation of competent authorities, the wanted person was detained in Indonesia.");
INSERT INTO news(date, ru_title, ru_text, en_title, en_text, default_title, default_text)
VALUES("2018-12-07", 
"Из Таиланда депортирован обвиняемый в мошенничестве в кредитной сфере", 
"«Сотрудниками российского бюро Интерпола в Россию доставлен депортированный из Таиланда Роман Дмитрук, обвиняемый в совершении преступлений, предусмотренных частью 4 статьи 159.1 УК РФ», - сообщила официальный представитель МВД России Ирина Волк.\r\n
Установлено, что фигурант с целью хищения денежных средств у кредитных организаций в городе Владивостоке создал организованную группу, участники которой готовили подложные документы и предоставляли их в банки для получения займов. Сообщники были задержаны сотрудниками полиции при попытке получить очередной кредит.\r\n
Лидеру группы удалось скрыться. На основании запроса УМВД России по Приморскому краю в январе текущего года он был объявлен в международный розыск. В результате международного взаимодействия Роман Дмитрук задержан в Тайланде и доставлен в Москву.", 
"A suspect of credit fraud was deported from Thailand", 
"“Roman Dmitruk, accused of committing crimes stipulated by part 4 of Article 159.1 of the RF Criminal Code was deported from Thailand and, was delivered to Russia by officers of the Russian Bureau of Interpol,” said the official representative of the Russian MIA Irina Volk.\r\n
It has been established that the suspect with the aim of stealing money from credit institutions in the city of Vladivostok created an organized group, the participants of which prepared false documents and submitted them to banks for receiving loans. The accomplices were detained by police when trying to get another loan.\r\n
The group leader managed to escape. On the basis of the request of the MIA of Russia in the Primorsky Territory in January of this year, he was put on the international wanted list. As a result of international cooperation, Roman Dmitruk was detained in Thailand and taken to Moscow.", 
"A suspect of credit fraud was deported from Thailand", 
"“Roman Dmitruk, accused of committing crimes stipulated by part 4 of Article 159.1 of the RF Criminal Code was deported from Thailand and, was delivered to Russia by officers of the Russian Bureau of Interpol,” said the official representative of the Russian MIA Irina Volk.\r\n
It has been established that the suspect with the aim of stealing money from credit institutions in the city of Vladivostok created an organized group, the participants of which prepared false documents and submitted them to banks for receiving loans. The accomplices were detained by police when trying to get another loan.\r\n
The group leader managed to escape. On the basis of the request of the MIA of Russia in the Primorsky Territory in January of this year, he was put on the international wanted list. As a result of international cooperation, Roman Dmitruk was detained in Thailand and taken to Moscow.");
INSERT INTO news(date, ru_title, ru_text, en_title, en_text, default_title, default_text)
VALUES("2018-12-03", 
"В Россию экстрадирована обвиняемая в незаконном сбыте наркотических средств в составе преступного сообщества", 
"«В Россию из Вьетнама в сопровождении сотрудников российского Бюро Интерпола и ФСИН России доставлена Ксения Турец-Афуда, 1992 года рождения, обвиняемая в совершении преступлений, предусмотренных частью 2 статьи 210, пунктами «а, г» части 3 статьи 228.1 УК РФ», - сообщила официальный представитель МВД России Ирина Волк.\r\n
По имеющейся информации, женщина входила в состав организованного преступного сообщества, которое осуществляло на территории Сахалинской области незаконный сбыт наркотических средств.\r\n
В международный розыск обвиняемая объявлена в апреле 2016 года на основании запроса УМВД России по Сахалинской области, а в июне 2018 года задержана на территории Вьетнама. Сегодня она доставлена в Москву.", 
"A suspect of illegal sale of drugs as part of a criminal community was extradited to Russia", 
"“Ksenia Turets-Afuda, born in 1992, accused of committing crimes provided for by part 2 of Article 210, paragraphs ‘a’, ‘d’ of part 3 of Article 228.1 of the Criminal Code of the Russian Federation, accompanied by officers of the Russian Bureau of Interpol and the Federal Penitentiary Service, was delivered to Russia from Vietnam,” said the official representative of the MIA of Russia Irina Volk.\r\n
According to the available information, the woman was a member of an organized criminal community, which carried out the illegal sale of narcotic drugs in the Sakhalin Region.\r\n
The defendant was announced wanted by the Interpol in April 2016 on the basis of a request from the MIA of Russia Administration for the Sakhalin Region, and in June 2018 was detained on the territory of Vietnam. Today she was brought to Moscow.", 
"A suspect of illegal sale of drugs as part of a criminal community was extradited to Russia", 
"“Ksenia Turets-Afuda, born in 1992, accused of committing crimes provided for by part 2 of Article 210, paragraphs ‘a’, ‘d’ of part 3 of Article 228.1 of the Criminal Code of the Russian Federation, accompanied by officers of the Russian Bureau of Interpol and the Federal Penitentiary Service, was delivered to Russia from Vietnam,” said the official representative of the MIA of Russia Irina Volk.\r\n
According to the available information, the woman was a member of an organized criminal community, which carried out the illegal sale of narcotic drugs in the Sakhalin Region.\r\n
The defendant was announced wanted by the Interpol in April 2016 on the basis of a request from the MIA of Russia Administration for the Sakhalin Region, and in June 2018 was detained on the territory of Vietnam. Today she was brought to Moscow.");

CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
);

INSERT INTO user_role(name)
VALUES("admin");
INSERT INTO user_role(name)
VALUES("client");

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_role_id` int(1) NOT NULL,
  `login` varchar(50) NOT NULL,
  `password` varchar(60) NOT NULL,
  `email` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `user_role_fk_idx` (`user_role_id`),
  CONSTRAINT `user_role_fk` FOREIGN KEY (`user_role_id`) REFERENCES `user_role` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
);

INSERT INTO user(user_role_id, login, password, email, first_name, last_name)
VALUES(1, "admin", "$2a$10$5cXbc/vvmRXhp1fAyoK4C.rh9GeGD36qHtChfxzMlkMSarTqMHxvq", "admin@mail.ru", "Иван", "Петров");
INSERT INTO user(user_role_id, login, password, email, first_name, last_name)
VALUES(2, "client", "$2a$10$eMFpg8Hl.2UH89qCqyUJYuQ3TWIA2LyY2d0hO8GlBZni5/c0KkwiW", "client@mail.ru", "Николай", "Фёдоров");

CREATE TABLE `person_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
);

INSERT INTO person_type(name)
VALUES("missing");
INSERT INTO person_type(name)
VALUES("wanted");

CREATE TABLE `person_sex` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
);

INSERT INTO person_sex(name)
VALUES("male");
INSERT INTO person_sex(name)
VALUES("female");

CREATE TABLE `request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(100) NOT NULL,
  `sex_id` int(1) NOT NULL,
  `type_id`  int(1) NOT NULL,
  `birth_date` datetime NOT NULL,
  `nationality` varchar(20) NOT NULL,
  `file_link` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO request(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("BRANDT ALEXANDRA SACHA",2,1,"1984-12-08","Israel","\\images\\persons\\ce850b00-111f-4a2e-a48d-d148f97cb017");
INSERT INTO request(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("THOMPSON JAMIE",1,1,"1973-07-26","United Kingdom","\\images\\persons\\1379b0cd-820f-4a7f-9fc1-083acd0d96fa");
INSERT INTO request(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("CANTET JEROME",1,1,"1981-07-11","France","\\images\\persons\\a790118c-68b5-42d8-b8c8-3b9da08e89d3");
INSERT INTO request(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("MARTILLO LUISA DE LOS ANGELES",2,1,"1990-12-09","Ecuador","\\images\\persons\\2ca83857-ef9d-4b5e-8961-66569cd35b33");
INSERT INTO request(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("CARROL DAVID MACDONALD",1,2,"1952-04-01","Canada","\\images\\persons\\97987903-3233-4c74-afeb-d1ce56eb7886");
INSERT INTO request(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("PICTOU GREGORY ALLAN",1,2,"1954-06-13","Canada","\\images\\persons\\f1cd80df-8035-44b5-9a53-7c6fb6f1a630");
INSERT INTO request(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("ANGLES MARTINS ANTONIO",1,2,"1966-07-25","Spain","\\images\\persons\\7a2eb359-b83a-45e9-b108-4ad76c00c064");
INSERT INTO request(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("ZHANG ZHUN",1,2,"1963-11-20","China","\\images\\persons\\c9a93022-68c3-47f5-979b-3d98b8ba24e5");

CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(100) NOT NULL,
  `sex_id` int(1) NOT NULL,
  `type_id`  int(1) NOT NULL,
  `birth_date` datetime NOT NULL,
  `nationality` varchar(20) NOT NULL,
  `file_link` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO person(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("BUSTO LUIS OSVALDO",1,2,"1968-06-16","Argentina","\\images\\persons\\89e61997-0624-43d7-9e14-275c9a56fcaa");
INSERT INTO person(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("MUNIZ VILLAR PABLO ALVARO",1,2,"1987-11-14","Uruguay","\\images\\persons\\2b744140-e18c-44a2-9da8-75001adb488b");
INSERT INTO person(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("GARCIA ROBERTO ANDRES",1,2,"1997-03-23","Argentina","\\images\\persons\\69c50735-941d-465c-9297-3f7b97bb01bb");
INSERT INTO person(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("VARELA FRANCO NAHUEL",1,2,"1995-02-24","Argentina","\\images\\persons\\a808f290-5b8a-41f8-86d4-54b2847c0c9f");
INSERT INTO person(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("VALENSKI BENVOLIO FRANCOIS CAITANYA",1,2,"1991-12-21","Guyana","\\images\\persons\\7019999a-cb45-4158-af5c-c7d48a43d41f");
INSERT INTO person(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("CORTEZ CRISTIAN ARIEL",1,2,"1993-02-07","Argentina","\\images\\persons\\a4e316e9-ffa4-4db4-a947-85f1deed45c7");
INSERT INTO person(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("PEREYRA DANIEL ARMANDO",1,2,"1994-11-08","Argentina","\\images\\persons\\47885ba7-9f55-4562-a598-455567fdde60");
INSERT INTO person(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("PEREZ MARCOS HIGINIO",1,2,"1988-05-18","Argentina","\\images\\persons\\a9be99c3-3209-4590-85ab-05011d6417a4");
INSERT INTO person(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("VU MANH HAU",1,2,"1995-10-03","Viet nam","\\images\\persons\\c08615ad-3c0d-41cf-8b01-6b46bfca2259");
INSERT INTO person(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("ALLEN CHURISAN BARTOLOMEO GREGORIO",1,1,"1973-04-09","Netherlands","\\images\\persons\\0d2e1a65-0f9f-418b-90cc-9e5f305f5a4e");
INSERT INTO person(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("AL-NASSER HANEEN KAMAL QASEM",2,1,"2005-03-14","Jordan","\\images\\persons\\8c187b89-151c-4afa-983b-f0353e0dbaf8");
INSERT INTO person(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("AL-NASSER JENNAH KAMAL QASEM",2,1,"2002-11-20","Jordan","\\images\\persons\\f5c04458-dfb0-4d39-8e2f-68ae5898d1f6");
INSERT INTO person(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("AL-NASSER JUDE KAMAL QASEM",2,1,"2000-07-31","Jordan","\\images\\persons\\b1938f2d-52d2-443b-ba0f-3deffb3ddff5");
INSERT INTO person(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("ALONSO QUIMI LAURA NELLY",2,1,"1988-08-09","Ecuador","\\images\\persons\\e5fdf8e7-7ca1-4275-ab5f-d95810241f60");
INSERT INTO person(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("ALONZO BARRERA DANNY MANRIQUE",1,1,"2001-09-07","Honduras","\\images\\persons\\f1d91745-e174-494a-8d36-2f0589f5c35f");
INSERT INTO person(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("ALIEVI GIORGI",1,1,"1996-09-24","Georgia","\\images\\persons\\e9bf0939-5a9f-46d1-97e8-407b67d63f14");
INSERT INTO person(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("ALTAMIRANO PONCE BRAYAN EDGARDO",1,1,"2014-12-04","Honduras","\\images\\persons\\b6b71f84-7e25-48b9-80b3-631aa4259e77");
INSERT INTO person(full_name, sex_id, type_id, birth_date, nationality, file_link)
VALUES("ALBUSHARI ABDAL WAKEEL",1,1,"2005-01-01","Sudan","\\images\\persons\\55e0a491-1fb6-4b95-9d32-cac28a422b92");


