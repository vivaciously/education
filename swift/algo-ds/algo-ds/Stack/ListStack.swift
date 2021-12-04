//
//  ListStack.swift
//  algo-ds
//
//  Created by Shin on 2021/12/04.
//

import Foundation

struct ListStack<T>: Stack {
    
    public var isEmpty: Bool {
        list.isEmpty
    }
    
    public var count: Int {
        list.count
    }
    
    public var top: T? {
        list.peekLast()
    }
    
    public mutating func push(_ element: T) {
        list.append(element)
    }
    
    @discardableResult
    public mutating func pop() -> T? {
        list.popLast()
    }
    
    public mutating func clear() {
        list.removeAll()
    }
    
    private var list: SingleLinkedList<T>
    
    public init() {
        list = SingleLinkedList()
    }
    
    public init(from array: [T]) {
        list = SingleLinkedList(from: array)
    }
    
}

extension ListStack: ExpressibleByArrayLiteral {
    public init(arrayLiteral elements: T ...) {
        list = SingleLinkedList<T>(from: elements)
    }
}
