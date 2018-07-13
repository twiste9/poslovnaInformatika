insert into BANKA values (1, 'Bulevar oslobođenja 5, Novi Sad', false, 'erstebanka@gmail.com', '12356789',  'Erste', '101626723',  '340',' CONARS22,', '0800 201 201', 'https://www.erstebank.rs');
insert into BANKA values (2, 'Bulevar Mihajla Pupina 4, Novi Sad', false, 'intesabanka@gmail.com', '12356789',  'Intesa', '100001159',  '160','VBUBRS22', '011 3108888', 'http://www.bancaintesa.rs');

insert into DRZAVA values (1, 'Srbija');
insert into DRZAVA values (2, 'Nemačka');

insert into VRSTA_PLACANJA values (1, 'Vrsta 1');
insert into VRSTA_PLACANJA values (2, 'Vrsta 2');

insert into VALUTA values (1, true, 'Dinar', 'RSD', 1);
insert into VALUTA values (2, false, 'Euro', 'EUR' , 1);
insert into VALUTA values (3, false,  'American dollar', 'USD', 1);

insert into KLIJENT values (1, 'Zeleznicka 15', 'dejanbesic@yahoo.com', '$2a$10$x9IJmUtQpWc/L0yFDcUQSuhHNpPBpW67zDialYFSQmurPs1isvyNG', '0615593480');
insert into KLIJENT values (2, 'Sekspirova 28', 'stefanradanovic@gmail.com', '$2a$10$x9IJmUtQpWc/L0yFDcUQSuhHNpPBpW67zDialYFSQmurPs1isvyNG', '0652508824');
insert into KLIJENT values (3, 'Devet jugovica 5', 'gulamario95@gmail.com', 'a' ,'0614240218');

insert into FIZICKO_LICE values ('009970441', 'Dejan', '0809995820239', 'Besic', 1);
insert into FIZICKO_LICE values ('009970541', 'Mario', '1234567890123', 'Gula', 3);

insert into PRAVNO_LICE values( '87654321', 'Stefanova firma', 'PIB654321', 2);

insert into KURSNA_LISTA values (1, 1, '2018-07-16', '2018-07-07', 1);
insert into KURSNA_LISTA values (2, 1, '2018-07-16', '2018-07-07', 2);

insert into NASELJENO_MESTO values (1, 'Novi Sad', '21000', 1);
insert into NASELJENO_MESTO values (2, 'Subotica', '24000', 1);

insert into TEKUCI_RACUN values (1, '123123456789012312', '2018-07-10', true, 1, 1, 1);
insert into TEKUCI_RACUN values (2, '321321098765432121', '2018-07-10', true, 2, 2, 1);
insert into TEKUCI_RACUN values (3, '213987654321032101', '2018-07-10', true, 1, 3, 1);
insert into TEKUCI_RACUN values (4, '321321098765432100', '2018-07-10', true, 2, null, 1);
insert into TEKUCI_RACUN values (5, '213987654321032100', '2018-07-10', true, 1, null, 1);

insert into DNEVNO_STANJE_RACUNA values (1, '2018-07-11', 10000.00, 0.00, 0, 10000.00, 1);
insert into DNEVNO_STANJE_RACUNA values (2, '2018-07-12', 9000.00, 10000.00, 1000.00, 0.00, 1);
insert into DNEVNO_STANJE_RACUNA values (3, '2018-07-12', 8000.00, 9000.00, 1000.00, 0.00, 1);
insert into DNEVNO_STANJE_RACUNA values (4, '2018-07-12', 9000.00, 8000.00, 2000.00, 3000.00, 1);
insert into DNEVNO_STANJE_RACUNA values (11, '2018-07-11', 10000.00, 0.00, 0, 10000.00, 3);
insert into DNEVNO_STANJE_RACUNA values (12, '2018-07-12', 9000.00, 10000.00, 1000.00, 0.00, 3);
insert into DNEVNO_STANJE_RACUNA values (13, '2018-07-12', 8000.00, 9000.00, 1000.00, 0.00, 3);
insert into DNEVNO_STANJE_RACUNA values (14, '2018-07-12', 9000.00, 8000.00, 2000.00, 3000.00, 3);
insert into DNEVNO_STANJE_RACUNA values (5, '2018-07-12', 9000.00, 8000.00, 2000.00, 3000.00, 4);
insert into DNEVNO_STANJE_RACUNA values (15, '2018-07-11', 10000.00, 0.00, 0, 10000.00, 5);
insert into DNEVNO_STANJE_RACUNA values (16, '2018-07-11', 10000.00, 0.00, 0, 10000.00, 2);

insert into ANALITIKA_IZVODA values (1, '2018-07-11', 'Mario Gula', false, 10000.00, 97, 97, 'poz na br odob', 'poz na br zad', 'Dejan Besic', '213987654321032101', '123123456789012312', 1, 's', 'Uplata tako random 1', -1, 1, 1, 1, 1);
insert into ANALITIKA_IZVODA values (2, '2018-07-12', 'Dejan Besic', false, 1000.00, 97, 97, 'poz na br odob', 'poz na br zad', 'Stefan Radanovic', '123123456789012312', '321321098765432121', 1, 's', 'Uplata na firmu 1', -1, 2, 2, 1, 1);
insert into ANALITIKA_IZVODA values (3, '2018-07-13', 'Dejan Besic', false, 500.00, 97, 97, 'poz na br odob', 'poz na br zad', 'Stefan Radanovic', '123123456789012312', '321321098765432121', 1, 's', 'Uplata na firmu 2', -1, 2, 3, 1, 1);
insert into ANALITIKA_IZVODA values (4, '2018-07-13', 'Dejan Besic', false, 500.00, 97, 97, 'poz na br odob', 'poz na br zad', 'Stefan Radanovic', '123123456789012312', '321321098765432121', 1, 's', 'Uplata na firmu 3', -1, 2, 3, 1, 1);
insert into ANALITIKA_IZVODA values (5, '2018-07-14', 'Dejan Besic', false, 2000.00, 97, 97, 'poz na br odob', 'poz na br zad', 'Stefan Radanovic', '123123456789012312', '321321098765432121', 1, 's', 'Uplata na firmu 4', -1, 2, 4, 1, 1);
insert into ANALITIKA_IZVODA values (6, '2018-07-14', 'Mario Gula', false, 1500.00, 97, 97, 'poz na br odob', 'poz na br zad', 'Dejan Besic', '213987654321032101', '123123456789012312', 1, 's', 'Uplata tako random 2', -1, 1, 4, 1, 1);
insert into ANALITIKA_IZVODA values (7, '2018-07-14', 'Mario Gula', false, 1500.00, 97, 97, 'poz na br odob', 'poz na br zad', 'Dejan Besic', '213987654321032101', '123123456789012312', 1, 's', 'Uplata tako random 3', -1, 1, 4, 1, 1);

--insert into ANALITIKA_IZVODA values (1, '2018-07-11', 'Mario Gula', false, 10000.00, 97, 97, 'poz na br odob', 'poz na br zad', 'Dejan Besic', '213987654321032101', '123123456789012312', 1, 's', 'Uplata tako random', 1, 1, 1, 1);

--insert into FIZICKO_LICE values(1, 'Zeleznicka 15', 'dejanbesic@yahoo.com', 'Dejan', '0809995820238', 'Besic', '0615593480');
--insert into FIZICKO_LICE values(2, 'Sekspirova 28', 'stefanradanovic@gmail.com', 'Stefan', '1234567890123', 'Radanovic', '0652508824');
--insert into FIZICKO_LICE values(3, 'Devet Jugovica 5', 'mariogula@gmail.com', 'Mario', '1234567890123', 'Gula', '0614240218');
--
--insert into PRAVNO_LICE values(1, 'Zeleznicka 15', 'dejanbesic@yahoo.com', '12345678', 'Beiiiiiii', 'PIB123456', '0615593480');
--insert into PRAVNO_LICE values(2, 'Sekspirova 28', 'stefanradanovic@gmail.com', '87654321', 'Alen, Alen, Stiv', 'PIB654321', '0652508824');
--insert into PRAVNO_LICE values(3, 'Devet Jugovica 5', 'mariogula@gmail.com', '01234567', 'Guxla', 'PIB012345', '0614240218');