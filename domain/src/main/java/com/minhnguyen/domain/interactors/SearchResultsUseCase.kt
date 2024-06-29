package com.minhnguyen.domain.interactors

import com.minhnguyen.domain.SubjectInteractor
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchResultsUseCase @Inject constructor(

):
    SubjectInteractor<SearchResultsUseCase.Params, List<String>>() {
    override fun createObservable(params: Params): Flow<List<String>> {
        TODO("Not yet implemented")
    }

    data class Params(val searchQuery: String)
}