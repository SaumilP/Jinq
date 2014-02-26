package ch.epfl.labos.iu.orm.query2;

import ch.epfl.labos.iu.orm.DBSet;
import ch.epfl.labos.iu.orm.DateSorter;
import ch.epfl.labos.iu.orm.DoubleSorter;
import ch.epfl.labos.iu.orm.IntSorter;
import ch.epfl.labos.iu.orm.Pair;
import ch.epfl.labos.iu.orm.QueryComposer;
import ch.epfl.labos.iu.orm.StringSorter;
import ch.epfl.labos.iu.orm.DBSet.Join;

// These methods will clobber the query passed into it when making a 
// new one, so be sure to always pass in a copy of the query instead 
//  of the original

public interface SQLQueryTransforms
{
   <T> SQLQuery<T> where(SQLQuery<T> query, int lambdaThisIndex, DBSet.Where<T> test, Object emSource);
   <T,U> SQLQuery<U> select(SQLQuery<T> query, int lambdaThisIndex, DBSet.Select<T,U> select, Object emSource);
   <T> SQLQuery<Integer> sumInt(SQLQuery<T> query, int lambdaThisIndex, DBSet.AggregateInteger<T> aggregate, Object emSource);
   <T> SQLQuery<Double> sumDouble(SQLQuery<T> query, int lambdaThisIndex, DBSet.AggregateDouble<T> aggregate, Object emSource);
   <T> SQLQuery<Integer> maxInt(SQLQuery<T> query, int lambdaThisIndex, DBSet.AggregateInteger<T> aggregate, Object emSource);
   <T> SQLQuery<Double> maxDouble(SQLQuery<T> query, int lambdaThisIndex, DBSet.AggregateDouble<T> aggregate, Object emSource);
   <T,U> SQLQuery<Pair<T,U>> join(SQLQuery<T> query, int lambdaThisIndex, DBSet.Join<T,U> join, Object emSource);
   <T,U> SQLQuery<U> selectAggregates(SQLQuery<T> query, int lambdaThisIndex, DBSet.AggregateSelect<T,U> join, Object emSource);
   <T,U,V> SQLQuery<Pair<U,V>> group(SQLQuery<T> query, int lambdaSelectThisIndex, DBSet.Select<T,U> select, int lambdaAggregateThisIndex, DBSet.AggregateGroup<U, T, V> aggregate, Object emSource);
   <T> SQLQuery<T> firstN(SQLQuery<T> query, int n, Object emSource);
   <T> SQLQuery<T> sortedByDate(SQLQuery<T> query, int lambdaThisIndex, DateSorter<T> sorter, boolean isAscending, Object emSource);
   <T> SQLQuery<T> sortedByInt(SQLQuery<T> query, int lambdaThisIndex, IntSorter<T> sorter, boolean isAscending, Object emSource);
   <T> SQLQuery<T> sortedByDouble(SQLQuery<T> query, int lambdaThisIndex, DoubleSorter<T> sorter, boolean isAscending, Object emSource);
   <T> SQLQuery<T> sortedByString(SQLQuery<T> query, int lambdaThisIndex, StringSorter<T> sorter, boolean isAscending, Object emSource);

}