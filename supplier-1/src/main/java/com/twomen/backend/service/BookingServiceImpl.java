package com.twomen.backend.service;

import com.twomen.backend.entity.*;
import com.twomen.backend.persistence.BookingDAO;
import com.twomen.backend.persistence.DAOFactory;
import com.twomen.backend.rest.NotFoundException;
import com.twomen.backend.specification.MatchesKeyWords;
import com.twomen.backend.specification.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
  private final BookingDAO dao;

  @Autowired
  public BookingServiceImpl(DAOFactory factory) {
    this.dao = factory.create();
  }

  @Override
  public List<Film> findAllFilmsByKeyWords(List<String> keyWords) {
    Specification<Film> specification = new MatchesKeyWords(keyWords);
    return dao.findAllBySpecification(specification);
  }
}
