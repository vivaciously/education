//
//  SingleLinkedList.swift
//  algo-ds
//
//  Created by Shin on 2021/11/13.
//

import Foundation

public struct SingleLinkedList<T> {
    
    public class Node<T>: CustomStringConvertible {
        var value: T
        var next: Node<T>?
        
        public init(value: T) {
            self.value = value
        }
        public var description: String {
            guard let next = next else { return "\(value)" }
            return "\(value) -> " + String(describing: next) + " "
        }
    }
    
    //typealias Node = ListNode<T>
    private var head: Node<T>?
    private(set) var count: Int = 0
    
    public var isEmpty: Bool {
        head == nil
    }
    
    private var last: Node<T>? {
        guard var node = head else {
            return nil
        }
        
        while node.next != nil {
            node = node.next!
        }
        return node
    }
    
    public init() {
        self.head = nil
    }
    
    public init(from array: [T]) {
        head = Node<T>(value: array[0])
        count += 1
        var node = head
        for i in 1 ..< array.count {
            node?.next = Node<T>(value: array[i])
            node = node?.next
            count += 1
        }
    }
    
    public mutating func append(_ value: T) {
        if head == nil {
            head = Node(value: value)
        } else {
            var node = head
            while let next = node?.next {
                node = next
            }
            node?.next = Node(value: value)
        }
        count += 1
    }
    
    public mutating func appendToFront(_ value: T) {
        if head == nil {
            head = Node(value: value)
        } else {
            let node = Node(value: value)
            node.next = head
            head = node
        }
        count += 1
    }
    
    public func peekFirst() -> T? {
        if head == nil {
            return nil
        } else {
            return head?.value
        }
    }
    
    public func peekLast() -> T? {
        guard let last = last else {
            return nil
        }
        return last.value
    }
    
    public subscript(index: Int) -> T? {
        let node = node(at: index)
        return node?.value
    }
    
    public mutating func insert(value: T, at index: Int) {
        guard index <= count else {
            return
        }
        if index == 0 {
            let node = Node(value: value)
            node.next = head
            head = node
        } else {
            var cur = head
            var curIndex = 0
            var prev: Node<T>? = nil
            while cur != nil && curIndex < index {
                prev = cur
                cur = cur?.next
                curIndex += 1
            }
            let node = Node(value: value)
            prev?.next = node
            node.next = cur
        }
        count += 1
    }
    
    public mutating func removeAll() {
        count = 0
        head = nil
    }
    
    @discardableResult
    public func node(at index: Int) -> Node<T>? {
        guard index < count else {
            return nil
        }
        var cur = head
        var curIndex = 0
        while cur != nil && curIndex < index {
            curIndex += 1
            cur = cur?.next
        }
        return cur
    }
    
    @discardableResult
    public mutating func remove(at index: Int) -> Node<T>? {
        guard index < count else {
            return nil
        }
        var cur = head
        var prev: Node<T>? = nil
        var curIndex = 0
        while cur != nil && curIndex < index {
            prev = cur
            cur = cur?.next
            curIndex += 1
        }
        prev?.next = cur?.next
        return cur
    }
    
    @discardableResult
    public mutating func removeFirst() -> Node<T>? {
        guard let node = head else {
            return nil
        }
        head = head?.next
        count -= 1
        return node
    }
    
    @discardableResult
    public mutating func popFirst() -> T? {
        if let node = removeFirst() {
            return node.value
        }
        return nil
    }
    
    @discardableResult
    public mutating func removeLast() -> Node<T>? {
        guard var node = head else {
            return nil
        }
        var prev: Node<T>? = nil
        while let next = node.next {
            prev = node
            node = next
        }
        prev?.next = nil
        count -= 1
        return node
    }
    
    @discardableResult
    public mutating func popLast() -> T? {
        if let node = removeLast() {
            return node.value
        }
        return nil
    }
    
    public mutating func reverse() {
        guard !isEmpty else {
            return
        }
        var cur = head
        var next: Node<T>? = nil
        var prev: Node<T>? = nil
        
        while cur != nil {
            next = cur?.next
            cur?.next = prev
            prev = cur
            cur = next
        }
        head = prev
    }
}

extension SingleLinkedList: CustomStringConvertible {
    public var description: String {
        guard let head = head else {
            return "List is empty."
        }
        return "SingleLinkedList:\n" + String(describing: head) + "\n"
    }
}

extension SingleLinkedList where T: Equatable {
    
    public func contains(value: T) -> Bool {
        guard var node = head else {
            return false
        }
        while let next = node.next {
            if node.value == value {
                return true
            }
            node = next
        }
        return false
    }
}

extension SingleLinkedList: ExpressibleByArrayLiteral {
    
    public init(arrayLiteral elements: T ...) {
        self.init(from: elements)
    }
}
