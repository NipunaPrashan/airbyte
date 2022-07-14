/*
 * Copyright (c) 2022 Airbyte, Inc., all rights reserved.
 */

package io.airbyte.integrations.source.postgres;

import com.fasterxml.jackson.databind.JsonNode;
import io.airbyte.db.jdbc.JdbcSourceOperations;

import java.sql.JDBCType;
import java.util.Set;

import static java.sql.JDBCType.BIGINT;
import static java.sql.JDBCType.CHAR;
import static java.sql.JDBCType.DATE;
import static java.sql.JDBCType.DECIMAL;
import static java.sql.JDBCType.DOUBLE;
import static java.sql.JDBCType.FLOAT;
import static java.sql.JDBCType.INTEGER;
import static java.sql.JDBCType.LONGVARCHAR;
import static java.sql.JDBCType.NCHAR;
import static java.sql.JDBCType.NUMERIC;
import static java.sql.JDBCType.NVARCHAR;
import static java.sql.JDBCType.REAL;
import static java.sql.JDBCType.SMALLINT;
import static java.sql.JDBCType.TIME;
import static java.sql.JDBCType.TIMESTAMP;
import static java.sql.JDBCType.TIMESTAMP_WITH_TIMEZONE;
import static java.sql.JDBCType.TIME_WITH_TIMEZONE;
import static java.sql.JDBCType.TINYINT;
import static java.sql.JDBCType.VARCHAR;

public class PostgresUtils {
  public static final Set<JDBCType> ALLOWED_CURSOR_TYPES = Set.of(TIMESTAMP, TIMESTAMP_WITH_TIMEZONE, TIME, TIME_WITH_TIMEZONE,
          DATE, TINYINT, SMALLINT, INTEGER, BIGINT, FLOAT, DOUBLE, REAL, NUMERIC, DECIMAL,
          CHAR, NCHAR, NVARCHAR, VARCHAR, LONGVARCHAR);

  private static final String PGOUTPUT_PLUGIN = "pgoutput";

  public static String getPluginValue(final JsonNode field) {
    return field.has("plugin") ? field.get("plugin").asText() : PGOUTPUT_PLUGIN;
  }

}
