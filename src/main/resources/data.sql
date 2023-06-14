-- Inserimento dati per la tabella "azienda"
INSERT INTO company (company_name, vat_number, address, iban, phone_number, email, pec, fax)
VALUES
  ('azienda 1', '12345678901', 'via roma 1', 'it12345678901234567890123', '0123456789', 'azienda1@email.com', 'azienda1@pec.com', NULL),
  ('azienda 2', '23456789012', 'via milano 2', 'it23456789012345678901234', '0234567890', 'azienda2@email.com', 'azienda2@pec.com', NULL),
  ('azienda 3', '34567890123', 'via napoli 3', 'it34567890123456789012345', '0345678901', 'azienda3@email.com', 'azienda3@pec.com', NULL),
  ('azienda 4', '45678901234', 'via venezia 4', 'it45678901234567890123456', '0456789012', 'azienda4@email.com', 'azienda4@pec.com', NULL),
  ('azienda 5', '56789012345', 'via firenze 5', 'it56789012345678901234567', '0567890123', 'azienda5@email.com', 'azienda5@pec.com', NULL),
  ('azienda 6', '12345678902', 'via roma 6', 'it123456789012345678901236', '0123456781', 'azienda6@email.com', 'azienda6@pec.com', NULL),
  ('azienda 7', '23456789013', 'via milano 7', 'it234567890123456789012347', '0234567892', 'azienda7@email.com', 'azienda7@pec.com', NULL),
  ('azienda 8', '34567890124', 'via napoli 8', 'it345678901234567890123458', '0345678903', 'azienda8@email.com', 'azienda8@pec.com', NULL),
  ('azienda 9', '45678901235', 'via venezia 9', 'it456789012345678901234569', '0456789014', 'azienda9@email.com', 'azienda9@pec.com', NULL),
  ('azienda 10', '56789012346', 'via firenze 10', 'it567890123456789012345670', '0567890125', 'azienda10@email.com', 'azienda10@pec.com', NULL);

-- Inserimento dati per la tabella "cliente"
INSERT INTO customer (customer_name, vat_number, address, cap, city, iban, phone_number, email, pec, fax)
VALUES
  ('cliente 1', 'it12345678901', 'via roma 1', '12345', 'roma', 'it98765432109876543210987', '0123456789', 'cliente1@email.com', 'cliente1@pec.com', NULL),
  ('cliente 2', 'it23456789012', 'via milano 2', '23456', 'milano', 'it87654321098765432109876', '0234567890', 'cliente2@email.com', 'cliente2@pec.com', NULL),
  ('cliente 3', 'it34567890123', 'via napoli 3', '34567', 'napoli', 'it76543210987654321098765', '0345678901', 'cliente3@email.com', 'cliente3@pec.com', NULL),
  ('cliente 4', 'it45678901234', 'via venezia 4', '45678', 'venezia', 'it65432109876543210987654', '0456789012', 'cliente4@email.com', 'cliente4@pec.com', NULL),
  ('cliente 5', 'it56789012345', 'via firenze 5', '56789', 'firenze', 'it54321098765432109876543', '0567890123', 'cliente5@email.com', 'cliente5@pec.com', NULL),
  ('cliente 6', 'it12345678906', 'via roma 6', '12346', 'roma', 'it98765432109876543210980', '0123456781', 'cliente6@email.com', 'cliente6@pec.com', NULL),
  ('cliente 7', 'it23456789017', 'via milano 7', '23457', 'milano', 'it87654321098765432109879', '0234567892', 'cliente7@email.com', 'cliente7@pec.com', NULL),
  ('cliente 8', 'it34567890128', 'via napoli 8', '34568', 'napoli', 'it76543210987654321098768', '0345678903', 'cliente8@email.com', 'cliente8@pec.com', NULL),
  ('cliente 9', 'it45678901239', 'via venezia 9', '45679', 'venezia', 'it65432109876543210987657', '0456789014', 'cliente9@email.com', 'cliente9@pec.com', NULL),
  ('cliente 10', 'it56789012340', 'via firenze 10', '56780', 'firenze', 'it54321098765432109876546', '0567890125', 'cliente10@email.com', 'cliente10@pec.com', NULL);

-- Inserimento dati per la tabella "azienda_cliente"
INSERT INTO company_customer (company_id, customer_id)
VALUES
  (1, 1),
  (1, 2),
  (2, 3),
  (3, 4),
  (4, 5),
  (5, 3),
  (5, 7),
  (7, 1),
  (8, 9),
  (10, 5);

-- Inserimento dati per la tabella "dipendente"
INSERT INTO employee (first_name, last_name, address, cap, city, iban, phone_number, email, contract_type, contract_start, company_id)
VALUES
  ('nome 1', 'cognome 1', 'via roma 1', '12345', 'roma', 'it9876543210987654321098711', '0123456789', 'dipendente1@email.com', 'indeterminato', '2022-01-01', 1),
  ('nome 2', 'cognome 2', 'via milano 2', '23456', 'milano', 'it8765432109876543210987622', '0234567890', 'dipendente2@email.com', 'determinato', '2022-02-01', 2),
  ('nome 3', 'cognome 3', 'via napoli 3', '34567', 'napoli', 'it7654321098765432109876533', '0345678901', 'dipendente3@email.com', 'indeterminato', '2022-03-01', 3),
  ('nome 4', 'cognome 4', 'via venezia 4', '45678', 'venezia', 'it6543210987654321098765444', '0456789012', 'dipendente4@email.com', 'determinato', '2022-04-01', 4),
  ('nome 5', 'cognome 5', 'via firenze 5', '56789', 'firenze', 'it5432109876543210987654355', '0567890123', 'dipendente5@email.com', 'indeterminato', '2022-05-01', 5),
  ('nome 6', 'cognome 6', 'via roma 6', '12341', 'roma', 'it9876543210987654321098266', '0123456781', 'dipendente6@email.com', 'indeterminato', '2022-01-01', 6),
  ('nome 7', 'cognome 7', 'via milano 7', '23452', 'milano', 'it8765432109876543210987377', '0234567897', 'dipendente7@email.com', 'determinato', '2022-02-01', 7),
  ('nome 8', 'cognome 8', 'via napoli 8', '34563', 'napoli', 'it7654321098765432109876488', '0345678904', 'dipendente8@email.com', 'indeterminato', '2022-03-01', 8),
  ('nome 9', 'cognome 9', 'via venezia 9', '45674', 'venezia', 'it6543210987654321098765599', '0456789013', 'dipendente9@email.com', 'determinato', '2022-04-01', 9),
  ('nome 10', 'cognome 10', 'via firenze 10', '56785', 'firenze', 'it5432109876543210987654610', '0567890121', 'dipendente10@email.com', 'indeterminato', '2022-05-01', 10);

-- Inserimento dati per la tabella "commessa"
INSERT INTO job (description, start_date, end_date, installments, customer_id)
VALUES
  ('commessa 1', '2022-01-01', '2022-02-01', 'rate 1', 1),
  ('commessa 2', '2022-02-01', '2022-03-01', 'rate 2', 2),
  ('commessa 3', '2022-03-01', '2022-04-01', 'rate 3', 3),
  ('commessa 4', '2022-04-01', '2022-05-01', 'rate 4', 4),
  ('commessa 5', '2022-05-01', '2022-06-01', 'rate 5', 5),
  ('commessa 6', '2022-01-01', '2022-02-01', 'rate 6', 10),
  ('commessa 7', '2022-02-01', '2022-03-01', 'rate 7', 9),
  ('commessa 8', '2022-03-01', '2022-04-01', 'rate 8', 8),
  ('commessa 9', '2022-04-01', '2022-05-01', 'rate 9', 7),
  ('commessa 10', '2022-05-01', '2022-06-01', 'rate 10', 6);

-- Inserimento dati per la tabella "dipendente_commessa"
INSERT INTO employee_job (employee_id, job_id)
VALUES
  (1, 1),
  (1, 2),
  (2, 3),
  (3, 4),
  (4, 5),
  (6, 4),
  (8, 7),
  (5, 3),
  (5, 1),
  (4, 9);