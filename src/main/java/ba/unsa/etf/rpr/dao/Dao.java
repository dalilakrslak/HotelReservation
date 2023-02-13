package ba.unsa.etf.rpr.dao;

import  ba.unsa.etf.rpr.exceptions.HotelException;

import java.util.List;

/**
 * Root interface for all DAO classes
 * @param <T>
 * @author Dalila Krslak
 */
public interface Dao<T> {

    /**
     * get entity from database base on ID
     * @param id primary key of entity
     * @return Entity from database
     */
    T getById(int id) throws HotelException;

    /**
     * Saves entity into database
     * @param item bean for saving to database
     * @throws HotelException in case of an error
     * @return saved item with id field populated
     */
    T add(T item) throws HotelException;

    /**
     * Fully updates entity in database based on id (primary) match.
     * @param item - bean to be updated. id must be populated
     * @throws HotelException in case of an error
     * @return updated version of bean
     */
    T update(T item) throws HotelException;

    /**
     * Hard delete of item from database with given id
     * @param id - primary key of entity
     * @throws HotelException in case of an error
     */
    void delete(int id) throws HotelException;

    /**
     * Lists all entities from database. WARNING: Very slow operation because it reads all records.
     * @throws HotelException in case of an error
     * @return List of entities from database
     */
    List<T> getAll() throws HotelException;
}