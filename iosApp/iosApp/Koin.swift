//
//  Koin.swift
//  iosApp
//
//  Created by 吉村琢磨 on 2023/05/20.
//  Copyright © 2023 orgName. All rights reserved.
//

import Foundation
import shared

func startKoin() {
    _koinApplication = KoinHelperKt.doInitKoin()
}
private var _koinApplication: Koin_coreKoinApplication?

var koinApplication: Koin_coreKoinApplication {
    return _koinApplication!
}


extension Koin_coreKoinApplication {
    func get<T>(objCClass: AnyClass) ->  T{
        return koinApplication.getDependency(objCClass: objCClass) as! T
    }
}
