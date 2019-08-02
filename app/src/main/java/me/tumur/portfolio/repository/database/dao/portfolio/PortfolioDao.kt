package me.tumur.portfolio.repository.database.dao.portfolio

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import me.tumur.portfolio.repository.database.model.portfolio.PortfolioModel
import me.tumur.portfolio.utils.constants.DbConstants

@Dao
abstract class PortfolioDao {

    /** Update */
    @Transaction
    open suspend fun update(list: List<PortfolioModel>): List<Long> {
        delete()
        return insert(list)
    }

    /** Insert */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(list: List<PortfolioModel>): List<Long>

    /** Delete */
    @Query(DbConstants.PORTFOLIO_DELETE)
    abstract suspend fun delete()

    /** Get list items */
    @Query(DbConstants.PORTFOLIO_GET_LIST_ITEMS)
    abstract fun getListItems(id: String): DataSource.Factory<Int, PortfolioModel>


    /** Get single item */
    @Query(DbConstants.PORTFOLIO_GET_SINGLE_ITEM)
    abstract fun getSingleItem(id: String): LiveData<PortfolioModel>

//    /** Search by query */
//    @Query(DbConstants.GET_PORTFOLIO_BY_QUERY)
//    abstract fun getByQuery(query: String): LiveData<List<PortfolioModel>>

}