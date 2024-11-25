CREATE TABLE IF NOT EXISTS mood (
    id SERIAL PRIMARY KEY,          
    song VARCHAR(255),     
    moodType VARCHAR(50), 
    description text      
);
