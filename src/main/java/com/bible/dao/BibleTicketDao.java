package com.bible.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bible.model.BibleTicket;

public interface BibleTicketDao extends JpaRepository<BibleTicket, Integer> {

}
