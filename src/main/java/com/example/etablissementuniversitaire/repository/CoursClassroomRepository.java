package com.example.etablissementuniversitaire.repository;

import com.example.etablissementuniversitaire.entity.CoursClassroom;
import com.example.etablissementuniversitaire.entity.Niveau;
import com.example.etablissementuniversitaire.entity.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursClassroomRepository extends JpaRepository<CoursClassroom,Integer> {

    @Modifying
    @Query("update CoursClassroom c set c.archive = TRUE")
    void archive();

    List<CoursClassroom> findBySpecialiteAndClasseNiveau(Specialite sp, Niveau nv);
}
