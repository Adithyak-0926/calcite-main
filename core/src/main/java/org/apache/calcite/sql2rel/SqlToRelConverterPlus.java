package org.apache.calcite.sql2rel;

import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
import org.apache.calcite.plan.RelOptCluster;
import org.apache.calcite.plan.RelOptPlanner;
import org.apache.calcite.plan.RelOptTable;
import org.apache.calcite.prepare.Prepare;
import org.apache.calcite.rel.type.RelDataTypeFactory;
import org.apache.calcite.rel.type.RelDataTypeSystem;
import org.apache.calcite.rex.RexBuilder;
import org.apache.calcite.rex.RexBuilderPlus;
import org.apache.calcite.rex.RexCall;
import org.apache.calcite.sql.SqlOperator;
import org.apache.calcite.sql.validate.SqlValidator;
import org.apache.calcite.sql2rel.SqlRexConvertletTable;
import org.apache.calcite.sql2rel.SqlToRelConverter;
import org.checkerframework.checker.nullness.qual.Nullable;

public class SqlToRelConverterPlus extends SqlToRelConverter {

  private RelDataTypeFactory typeFactory;

  public SqlToRelConverterPlus(RelOptTable.ViewExpander viewExpander, SqlValidator validator, Prepare.CatalogReader catalogReader, RelOptPlanner planner, RexBuilderPlus rexBuilderPlus, SqlRexConvertletTable convertletTable, RelDataTypeFactory typeFactory) {
    super(viewExpander, validator, catalogReader, planner, rexBuilderPlus, convertletTable);
    this.typeFactory = typeFactory;
  }

  @Override
  public RexBuilderPlus getRexBuilder(){
    return new RexBuilderPlus(typeFactory);
  }
}
