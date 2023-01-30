package uz.smartmuslim.adminpanel.domain.repository.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.smartmuslim.adminpanel.data.local.room.dao.AppealDao
import uz.smartmuslim.adminpanel.data.local.room.dao.UserDao
import uz.smartmuslim.adminpanel.data.remote.api.Api
import uz.smartmuslim.adminpanel.data.remote.response.AppealResponse
import uz.smartmuslim.adminpanel.data.remote.response.UserResponse
import uz.smartmuslim.adminpanel.data.utils.ResultData
import uz.smartmuslim.adminpanel.domain.repository.AppRepository
import java.io.IOException
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val appealDao: AppealDao,
    private val userDao: UserDao,
    private val api: Api
) : AppRepository {

    override fun getAllUsers(): Flow<ResultData<List<UserResponse>>> = flow {

        val response = api.getAllUsers()

        try {

            when (response.code()) {

                in 200..299 -> {
                    response.body()?.map {
                        userDao.insert(it.toEntity())
                    }
                }

                in 400..499 -> {

                }

                in 500..599 -> {

                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    override fun getAllAppeals(): Flow<ResultData<List<AppealResponse>>> = flow {

    }

    override fun getAllIsNotCompleteAppeals(): Flow<ResultData<List<AppealResponse>>> = flow {

    }

    override fun getAllIsCompleteAppeals(): Flow<ResultData<List<AppealResponse>>> = flow {

    }

}