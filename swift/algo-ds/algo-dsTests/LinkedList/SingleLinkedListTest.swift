//
//  SingleLinkedListTest.swift
//  algo-dsTests
//
//  Created by Shin on 2021/11/13.
//

import Foundation
import XCTest
@testable import algo_ds

class SingleLinkedListTest: XCTestCase {
    
    override func setUp() {
        super.setUp()
    }
    
    override func tearDown() {
        super.tearDown()
    }
    
    func testInitFromArray() {
        let list = SingleLinkedList(from: [1,2,3,4,5])
        XCTAssert(list.count == 5)
    }
    
    func testAppend() {
        var list = SingleLinkedList<Int>()
        XCTAssert(list.isEmpty)
        list.append(2)
        XCTAssert(!list.isEmpty)
        XCTAssert(list.count == 1)
        list.append(1)
        XCTAssert(list.count == 2)
    }
    
    func testAppendToFront() {
        var list = SingleLinkedList<Int>()
        list.appendToFront(2)
        XCTAssert(list.peekFirst() == 2)
        XCTAssert(!list.isEmpty)
        XCTAssert(list.count == 1)
        list.appendToFront(1)
        XCTAssert(list.peekFirst() == 1)
        list.appendToFront(3)
        XCTAssert(list.peekFirst() == 3)
        XCTAssert(list.peekLast() == 2)
    }
    
    func testNodeAt() {
        var list = SingleLinkedList(from: [1,2,3,4,5])
        for i in 0 ..< list.count {
            let node = list.node(at: i)
            XCTAssert(node?.value == i + 1)
        }
        var node = list.node(at: list.count)
        XCTAssert(node == nil)
        list = SingleLinkedList<Int>()
        node = list.node(at: list.count)
        XCTAssert(node == nil)
    }
    
    func testInsertAt() {
        var list = SingleLinkedList(from: [0,1,2,3,4,5])
        list.insert(value: 10, at: 0)
        XCTAssert(list.peekFirst() == 10)
        list.insert(value: 20, at: 1)
        XCTAssert(list[1] == 20)
        XCTAssert(list[0] == 10)
        XCTAssert(list[2] == 0)
    }
    
    func testPeekLast() {
        var list = SingleLinkedList<Int>()
        XCTAssert(list.peekLast() == nil)
        list.append(1)
        XCTAssert(list.peekLast() == 1)
        list.removeFirst()
        XCTAssert(list.peekLast() == nil)
        list.append(1)
        list.append(2)
        XCTAssert(list.peekLast() == 2)
        XCTAssert(list.count == 2)
    }
    
    func testSubscript() {
        let array = [0,1,2,3,4,5]
        let list = SingleLinkedList(from: array)
        for i in 0 ..< array.count {
            XCTAssert(array[i] == list[i])
        }
    }
    
    func testReverse() {
        let array = [0,1,2,3,4,5]
        var list :SingleLinkedList<Int> = [0,1,2,3,4,5]
        list.reverse()
        for i in 0 ..< array.count {
            XCTAssert(list[i] == array[array.count - i - 1])
        }
    }
    
    func testSort() {
        var list: SingleLinkedList<Int> = [5,1,3,2,4,0]
        list.sort()
        for i in 0 ..< list.count {
            XCTAssert(list[i] == i)
        }
    }
    
}
