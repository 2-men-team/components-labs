package com.twomen.backend.persistence;

import javax.validation.constraints.NotNull;

public interface DAOFactory {
  @NotNull AuthDAO create();
}
