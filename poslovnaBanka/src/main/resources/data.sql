insert into BANKA values (1, 'Bulevar oslobođenja 5, Novi Sad', false, 'erstebanka@gmail.com', '12356789',  'Erste', '101626723',  '340', '0800 201 201', 'https://www.erstebank.rs');
insert into BANKA values (2, 'Bulevar Mihajla Pupina 4, Novi Sad', false, 'intesabanka@gmail.com', '12356789',  'Intesa', '100001159',  '160', '011 3108888', 'http://www.bancaintesa.rs');

insert into DRZAVA values (1, 'Srbija');
insert into DRZAVA values (2, 'Nemačka');

insert into FIZICKO_LICE values(1, 'Zeleznicka 15', 'dejanbesic@yahoo.com', 'Dejan', '0809995820238', 'Besic', '0615593480');
insert into FIZICKO_LICE values(2, 'Sekspirova 28', 'stefanradanovic@gmail.com', 'Stefan', '1234567890123', 'Radanovic', '0652508824');
insert into FIZICKO_LICE values(3, 'Devet Jugovica 5', 'mariogula@gmail.com', 'Mario', '1234567890123', 'Gula', '0614240218');

insert into PRAVNO_LICE values(1, 'Zeleznicka 15', 'dejanbesic@yahoo.com', '12345678', 'Beiiiiiii', 'PIB123456', '0615593480');
insert into PRAVNO_LICE values(2, 'Sekspirova 28', 'stefanradanovic@gmail.com', '87654321', 'Alen, Alen, Stiv', 'PIB654321', '0652508824');
insert into PRAVNO_LICE values(3, 'Devet Jugovica 5', 'mariogula@gmail.com', '01234567', 'Guxla', 'PIB012345', '0614240218');

insert into KURSNA_LISTA values (1, 1, '2018-07-16', '2018-07-07', 1);
insert into KURSNA_LISTA values (2, 1, '2018-07-16', '2018-07-07', 2);

insert into NASELJENO_MESTO values (1, 'Novi Sad', '21000', 1);
insert into NASELJENO_MESTO values (2, 'Subotica', '24000', 1);

insert into TEKUCI_RACUN values (1, '123-1234567890123-12', '2018-07-10', 'FIZICKO', true, 1, null);
insert into TEKUCI_RACUN values (2, '321-3210987654321-21', '2018-07-10', 'PRAVNO', true, null, 2);
insert into TEKUCI_RACUN values (3, '213-9876543210321-01', '2018-07-10', 'PRAVNO', true, null, 3);