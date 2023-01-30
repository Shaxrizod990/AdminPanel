package uz.smartmuslim.adminpanel.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.smartmuslim.adminpanel.data.remote.response.AppealResponse
import uz.smartmuslim.adminpanel.data.remote.response.UserResponse
import uz.smartmuslim.adminpanel.data.utils.ResultData

interface AppRepository {

    fun getAllUsers(): Flow<ResultData<List<UserResponse>>>

    fun getAllAppeals(): Flow<ResultData<List<AppealResponse>>>

    fun getAllIsNotCompleteAppeals(): Flow<ResultData<List<AppealResponse>>>

    fun getAllIsCompleteAppeals(): Flow<ResultData<List<AppealResponse>>>

}