-- Inserimento dati per la tabella "azienda"
INSERT INTO company (company_name, vat_number, address, iban, phone_number, email, pec, fax)
VALUES
  ('Azienda 1', '12345678901', 'Via Roma 1', 'IT12345678901234567890123', '0123456789', 'azienda1@email.com', 'azienda1@pec.com', NULL),
  ('Azienda 2', '23456789012', 'Via Milano 2', 'IT23456789012345678901234', '0234567890', 'azienda2@email.com', 'azienda2@pec.com', NULL),
  ('Azienda 3', '34567890123', 'Via Napoli 3', 'IT34567890123456789012345', '0345678901', 'azienda3@email.com', 'azienda3@pec.com', NULL),
  ('Azienda 4', '45678901234', 'Via Venezia 4', 'IT45678901234567890123456', '0456789012', 'azienda4@email.com', 'azienda4@pec.com', NULL),
  ('Azienda 5', '56789012345', 'Via Firenze 5', 'IT56789012345678901234567', '0567890123', 'azienda5@email.com', 'azienda5@pec.com', NULL),
  ('Azienda 6', '12345678902', 'Via Roma 6', 'IT123456789012345678901236', '0123456781', 'azienda6@email.com', 'azienda6@pec.com', NULL),
  ('Azienda 7', '23456789013', 'Via Milano 7', 'IT234567890123456789012347', '0234567892', 'azienda7@email.com', 'azienda7@pec.com', NULL),
  ('Azienda 8', '34567890124', 'Via Napoli 8', 'IT345678901234567890123458', '0345678903', 'azienda8@email.com', 'azienda8@pec.com', NULL),
  ('Azienda 9', '45678901235', 'Via Venezia 9', 'IT456789012345678901234569', '0456789014', 'azienda9@email.com', 'azienda9@pec.com', NULL),
  ('Azienda 10', '56789012346', 'Via Firenze 10', 'IT567890123456789012345670', '0567890125', 'azienda10@email.com', 'azienda10@pec.com', NULL);

-- Inserimento dati per la tabella "cliente"
INSERT INTO customer (customer_name, vat_number, address, cap, city, iban, phone_number, email, pec, fax)
VALUES
  ('Cliente 1', 'IT12345678901', 'Via Roma 1', '12345', 'Roma', 'IT98765432109876543210987', '0123456789', 'cliente1@email.com', 'cliente1@pec.com', NULL),
  ('Cliente 2', 'IT23456789012', 'Via Milano 2', '23456', 'Milano', 'IT87654321098765432109876', '0234567890', 'cliente2@email.com', 'cliente2@pec.com', NULL),
  ('Cliente 3', 'IT34567890123', 'Via Napoli 3', '34567', 'Napoli', 'IT76543210987654321098765', '0345678901', 'cliente3@email.com', 'cliente3@pec.com', NULL),
  ('Cliente 4', 'IT45678901234', 'Via Venezia 4', '45678', 'Venezia', 'IT65432109876543210987654', '0456789012', 'cliente4@email.com', 'cliente4@pec.com', NULL),
  ('Cliente 5', 'IT56789012345', 'Via Firenze 5', '56789', 'Firenze', 'IT54321098765432109876543', '0567890123', 'cliente5@email.com', 'cliente5@pec.com', NULL),
  ('Cliente 6', 'IT12345678906', 'Via Roma 6', '12346', 'Roma', 'IT98765432109876543210980', '0123456781', 'cliente6@email.com', 'cliente6@pec.com', NULL),
  ('Cliente 7', 'IT23456789017', 'Via Milano 7', '23457', 'Milano', 'IT87654321098765432109879', '0234567892', 'cliente7@email.com', 'cliente7@pec.com', NULL),
  ('Cliente 8', 'IT34567890128', 'Via Napoli 8', '34568', 'Napoli', 'IT76543210987654321098768', '0345678903', 'cliente8@email.com', 'cliente8@pec.com', NULL),
  ('Cliente 9', 'IT45678901239', 'Via Venezia 9', '45679', 'Venezia', 'IT65432109876543210987657', '0456789014', 'cliente9@email.com', 'cliente9@pec.com', NULL),
  ('Cliente 10', 'IT56789012340', 'Via Firenze 10', '56780', 'Firenze', 'IT54321098765432109876546', '0567890125', 'cliente10@email.com', 'cliente10@pec.com', NULL);

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
  ('Nome 1', 'Cognome 1', 'Via Roma 1', '12345', 'Roma', 'IT98765432109876543210987', '0123456789', 'dipendente1@email.com', 'indeterminato', '2022-01-01', 1),
  ('Nome 2', 'Cognome 2', 'Via Milano 2', '23456', 'Milano', 'IT87654321098765432109876', '0234567890', 'dipendente2@email.com', 'determinato', '2022-02-01', 2),
  ('Nome 3', 'Cognome 3', 'Via Napoli 3', '34567', 'Napoli', 'IT76543210987654321098765', '0345678901', 'dipendente3@email.com', 'indeterminato', '2022-03-01', 3),
  ('Nome 4', 'Cognome 4', 'Via Venezia 4', '45678', 'Venezia', 'IT65432109876543210987654', '0456789012', 'dipendente4@email.com', 'determinato', '2022-04-01', 4),
  ('Nome 5', 'Cognome 5', 'Via Firenze 5', '56789', 'Firenze', 'IT54321098765432109876543', '0567890123', 'dipendente5@email.com', 'indeterminato', '2022-05-01', 5),
  ('Nome 6', 'Cognome 6', 'Via Roma 6', '12341', 'Roma', 'IT98765432109876543210982', '0123456781', 'dipendente6@email.com', 'indeterminato', '2022-01-01', 6),
  ('Nome 7', 'Cognome 7', 'Via Milano 7', '23452', 'Milano', 'IT87654321098765432109873', '0234567897', 'dipendente7@email.com', 'determinato', '2022-02-01', 7),
  ('Nome 8', 'Cognome 8', 'Via Napoli 8', '34563', 'Napoli', 'IT76543210987654321098764', '0345678904', 'dipendente8@email.com', 'indeterminato', '2022-03-01', 8),
  ('Nome 9', 'Cognome 9', 'Via Venezia 9', '45674', 'Venezia', 'IT65432109876543210987655', '0456789013', 'dipendente9@email.com', 'determinato', '2022-04-01', 9),
  ('Nome 10', 'Cognome 10', 'Via Firenze 10', '56785', 'Firenze', 'IT54321098765432109876546', '0567890121', 'dipendente10@email.com', 'indeterminato', '2022-05-01', 10);

-- Inserimento dati per la tabella "commessa"
INSERT INTO job (description, start_date, end_date, installments, customer_id)
VALUES
  ('Commessa 1', '2022-01-01', '2022-02-01', 'Rate 1', 1),
  ('Commessa 2', '2022-02-01', '2022-03-01', 'Rate 2', 2),
  ('Commessa 3', '2022-03-01', '2022-04-01', 'Rate 3', 3),
  ('Commessa 4', '2022-04-01', '2022-05-01', 'Rate 4', 4),
  ('Commessa 5', '2022-05-01', '2022-06-01', 'Rate 5', 5),
  ('Commessa 6', '2022-01-01', '2022-02-01', 'Rate 6', 10),
  ('Commessa 7', '2022-02-01', '2022-03-01', 'Rate 7', 9),
  ('Commessa 8', '2022-03-01', '2022-04-01', 'Rate 8', 8),
  ('Commessa 9', '2022-04-01', '2022-05-01', 'Rate 9', 7),
  ('Commessa 10', '2022-05-01', '2022-06-01', 'Rate 10', 6);

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