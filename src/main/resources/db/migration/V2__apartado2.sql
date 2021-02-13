ALTER TABLE `airplane`
    ADD COLUMN `technical_review` JSON NOT NULL;


ALTER TABLE `flight`
    ADD COLUMN `crew_members_id` JSON NOT NULL;

UPDATE `airplane` a
SET `technical_review` = (SELECT JSON_ARRAYAGG(JSON_OBJECT('technical_review', t.id, 'mechanical_employee', m.id))
                          FROM `technical_review` t JOIN `mechanical_employee` m ON m.id = t.mechanical_employee_id
                          WHERE a.id = t.checked_airplane_id);


UPDATE `flight` f
SET `crew_members_id` = (SELECT JSON_ARRAYAGG(c.crew_member_id)
                      FROM `crew_member_flight` c
                      WHERE f.id = c.flight_id);
