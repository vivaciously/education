//
//  ArrayStack.swift
//  algo-ds
//
//  Created by Shin on 2021/11/13.
//

import Foundation

struct ArrayStack<T>: Stack {
    
    
    private var array = [T]()
    
    public init(_ array: [T]) {
        self.array = array
    }
    
    public var isEmpty: Bool {
        array.isEmpty
    }
    
    public var count: Int {
        array.count
    }
    
    public var top: T? {
        array.last
    }
    
    public mutating func push(_ element: T) {
        array.append(element)
    }
    
    @discardableResult
    public mutating func pop() -> T? {
        array.popLast()
    }
    
    public mutating func clear() {
        array.removeAll()
    }
    
}

extension ArrayStack: ExpressibleByArrayLiteral {
    public init(arrayLiteral elements: T ...) {
        array = elements
    }
}
