//
//  MatrixTest.swift
//  algo-dsTests
//
//  Created by Shin on 2021/10/23.
//

import Foundation
import XCTest

@testable import algo_ds

class MatrixTest: XCTestCase {
    
    private let rowSize = 3
    private let columnSize = 4
    
    override func setUp() {
        super.setUp()
    }
    
    override func tearDown() {
        super.tearDown()
    }
    
    func testCount() {
        var matrix = Matrix(rows: rowSize, cols: columnSize, defaultValue: 2)
        XCTAssert(matrix.count == rowSize * columnSize)
        matrix[1,1] = nil
        XCTAssert(matrix.count == rowSize * columnSize - 1)
    }
}
