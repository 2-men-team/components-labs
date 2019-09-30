package com.twomen.backend.persistence;

import javax.validation.constraints.NotNull;

public interface DAOFactory {
  @NotNull BookingDAO create();
}
