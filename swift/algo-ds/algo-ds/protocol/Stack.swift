//
//  Stack.swift
//  algo-ds
//
//  Created by Shin on 2021/11/13.
//

import Foundation

public protocol Stack {
    
    associatedtype T
    
    var isEmpty: Bool {get}
    var count: Int {get}
    var top: T? {get}
    mutating func push(_ element: T)
    mutating func pop() -> T?
    mutating func clear() 
    
}
