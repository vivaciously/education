//
//  StringProtocolExtension.swift
//  algo-ds
//
//  Created by Shin on 2021/11/13.
//

import Foundation

extension StringProtocol {
    
    subscript(offset : Int) -> Character {
        self[index(startIndex, offsetBy: offset)]
    }
}
