//
//  ArrayStackTest.swift
//  algo-dsTests
//
//  Created by Shin on 2021/11/13.
//

import Foundation
import XCTest
@testable import algo_ds

class ArrayStackTest: XCTestCase {
    
    override func setUp() {
        super.setUp()
    }
    
    override func tearDown() {
        super.tearDown()
    }
    
    func testIsEmpty() {
        var stack = ArrayStack<Int>()
        XCTAssert(stack.isEmpty)
        stack.push(25)
        XCTAssert(!stack.isEmpty)
        stack.pop()
        XCTAssert(stack.isEmpty)
    }
    
    func testTop() {
        var stack = ArrayStack<Int>()
        XCTAssert(stack.top == nil)
        stack.push(90)
        XCTAssert(stack.top == 90)
        stack.push(80)
        XCTAssert(stack.top == 80)
        stack.pop()
        XCTAssert(stack.top == 90)
    }
    
    func testCount() {
        var stack = ArrayStack<Int>()
        for i in 0 ..< 10 {
            stack.push(i)
        }
        XCTAssert(stack.count == 10)
        stack.pop()
        XCTAssert(stack.count == 9)
        stack.clear()
        XCTAssert(stack.count == 0)
    }
    
    func testInitFromArray() {
        let array = [1,2,3,4,5]
        var stack = ArrayStack<Int>(array)
        var index = array.count - 1
        while stack.count > 0 {
            XCTAssert(stack.pop() == array[index])
            index -= 1
        }
    }
    
    func testInitFromArrayLiteral() {
        var stack = ArrayStack([1,2,3,4,5])
        var value = 5
        while !stack.isEmpty {
            XCTAssert(stack.pop() == value)
            value -= 1
        }
    }
    
    
}
