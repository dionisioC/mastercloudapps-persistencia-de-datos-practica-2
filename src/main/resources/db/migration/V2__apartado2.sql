ALTER TABLE `airplane`
    ADD COLUMN `revision_summary` JSON NOT NULL;


ALTER TABLE `flight`
    ADD COLUMN `crew_members_id` JSON NOT NULL;

UPDATE `airplane` airplane
SET `revision_summary` = (SELECT JSON_ARRAYAGG(
                                                JSON_OBJECT('id', t.id,
                                                            'endDate', t.end_date,
                                                            'startDate', t.start_date,
                                                            'reviewType', t.review_type,
                                                            'workDescription', t.work_description,
                                                            'spentHoursOnReview', t.spent_hours_on_review,
                                                            'airport', JSON_OBJECT('id', airport.id,
                                                                                   'city', airport.city,
                                                                                   'name', airport.name,
                                                                                   'country', airport.country,
                                                                                   'iataCode', airport.iata_code
                                                                                   ),
                                                            'mechanicalEmployee', JSON_OBJECT('id', m.id,
                                                                                              'code', m.code,
                                                                                              'name', m.name,
                                                                                              'company', m.company,
                                                                                              'lastName', m.last_name,
                                                                                              'education', m.education,
                                                                                              'startingDate', m.starting_date
                                                                                             )
                                                            )
                                               )
                          FROM `technical_review` t JOIN `mechanical_employee` m ON m.id = t.mechanical_employee_id JOIN `airport` airport ON airport.id = t.airport_id
                          WHERE airplane.id = t.checked_airplane_id);


UPDATE `flight` f
SET `crew_members_id` = (SELECT JSON_ARRAYAGG(c.crew_member_id)
                      FROM `crew_member_flight` c
                      WHERE f.id = c.flight_id);
